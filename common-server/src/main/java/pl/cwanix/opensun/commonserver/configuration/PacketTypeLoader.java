package pl.cwanix.opensun.commonserver.configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessor;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketException;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;
import pl.cwanix.opensun.utils.datatypes.SUNDataType;
import pl.cwanix.opensun.utils.functions.ThrowingFunction;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class PacketTypeLoader {

	private static final Marker MARKER = MarkerFactory.getMarker("PACKET TYPE LOADER");

	private final SUNPacketProcessorExecutor processorExecutor;

	@Bean
	@SuppressWarnings("unchecked")
	public Map<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> clientPacketDefinitions() throws ClassNotFoundException {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new AnnotationTypeFilter(IncomingPacket.class));

		Map<PacketHeader, List<Class<? extends Packet>>> classes = new HashMap<>();
		Set<BeanDefinition> packetDefinitions = classPathScanner.findCandidateComponents("pl.cwanix.opensun");

		for (BeanDefinition packetDefinition : packetDefinitions) {
			Class<? extends Packet> packetClass = (Class<? extends Packet>) Class.forName(packetDefinition.getBeanClassName());
			PacketHeader header = new PacketHeader(packetClass.getAnnotation(IncomingPacket.class).category().getCategory(), packetClass.getAnnotation(IncomingPacket.class).type());

			checkIncomingPacketContract(packetClass);

			classes.merge(header, Collections.singletonList(packetClass), (l1, l2) ->
				Stream.of(l1, l2)
						.flatMap(Collection::stream)
						.collect(Collectors.toList())
			);
		}

		checkPacketDuplicates(classes);
		classes.forEach((key, value) -> log.debug(MARKER, "Loaded incoming packet type: {}", value.get(0).getSimpleName()));

		return classes.entrySet()
				.stream()
				.map(this::mapClassEntryToConstructorFunctionEntry)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}

	@Bean
	@SuppressWarnings("unchecked")
	public void serverPacketDefinitions() throws ClassNotFoundException {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new AnnotationTypeFilter(OutgoingPacket.class));

		Map<PacketHeader, List<Class<? extends Packet>>> classes = new HashMap<>();
		Set<BeanDefinition> packetDefinitions = classPathScanner.findCandidateComponents("pl.cwanix.opensun");

		for (BeanDefinition packetDefinition : packetDefinitions) {
			Class<? extends Packet> packetClass = (Class<? extends Packet>) Class.forName(packetDefinition.getBeanClassName());
			PacketHeader header = new PacketHeader(packetClass.getAnnotation(OutgoingPacket.class).category().getCategory(), packetClass.getAnnotation(OutgoingPacket.class).type());

			checkOutgoingPacketContract(packetClass);

			classes.merge(header, Collections.singletonList(packetClass), (l1, l2) ->
					Stream.of(l1, l2)
							.flatMap(Collection::stream)
							.collect(Collectors.toList())
			);
		}

		checkPacketDuplicates(classes);

		classes.forEach((key, value) -> log.debug(MARKER, "Loaded outgoing packet type: {}", value.get(0).getSimpleName()));
	}

	private Map.Entry<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> mapClassEntryToConstructorFunctionEntry(Map.Entry<PacketHeader, List<Class<? extends Packet>>> entry) {
		Constructor<? extends Packet> packetConstructor = getIncomingPacketConstructor(entry.getValue().get(0));
		ThrowingFunction<byte[], Packet, Exception> packetConstructorFunction = packetConstructor::newInstance;

		return new AbstractMap.SimpleEntry<>(entry.getKey(), packetConstructorFunction);
	}

	private Constructor<? extends Packet> getIncomingPacketConstructor(Class<? extends Packet> packetClass) {
		try {
			return packetClass.getConstructor(byte[].class);
		} catch (NoSuchMethodException e) {
			throw new PacketException("IncomingPacket should implement constructor with one byte[] argument", e);
		}
	}

	private void checkIncomingPacketContract(Class<? extends Packet> packetClass) {
		SUNPacketProcessor processor = processorExecutor.getProcessor(packetClass);

		if (Objects.isNull(processor)) {
			throw new PacketException("No matching processor for the packet type: " + packetClass.getSimpleName());
		}
	}

	private void checkOutgoingPacketContract(Class<? extends Packet> packetClass) {
		Class implementingClass;

		try {
			implementingClass = packetClass.getMethod("getOrderedFields").getDeclaringClass();
		} catch (NoSuchMethodException e) {
			throw new PacketException("Wrong OutgoingPacket definition", e);
		}

		if (implementingClass.equals(SUNDataType.class)) {
			throw new PacketException("OutgoingPacket (" + packetClass.getSimpleName() + ") should implement own getOrderedFields() method");
		}
	}

	private void checkPacketDuplicates(Map<PacketHeader, List<Class<? extends Packet>>> classes) {
		boolean dup = false;

		for (Map.Entry<PacketHeader, List<Class<? extends Packet>>> entry : classes.entrySet()) {
			if (entry.getValue().size() > 1) {
				dup = true;
				log.error(MARKER, "Duplicate packet definitions: {}", entry.getValue().stream().map(Class::getSimpleName).collect(Collectors.joining(", ")));
			}
		}

		if (dup) {
			throw new PacketException("Duplicate packet definitions");
		}
	}
}
