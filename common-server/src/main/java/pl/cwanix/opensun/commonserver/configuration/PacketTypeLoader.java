package pl.cwanix.opensun.commonserver.configuration;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketException;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;
import pl.cwanix.opensun.utils.datatypes.SUNDataType;
import pl.cwanix.opensun.utils.functions.ThrowingFunction;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
public class PacketTypeLoader {

	private static final Marker MARKER = MarkerFactory.getMarker("PACKET TYPE LOADER");

	@Bean
	@SuppressWarnings("unchecked")
	public Map<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> clientPacketDefinitions() throws ClassNotFoundException, PacketException {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new AnnotationTypeFilter(IncomingPacket.class));

		Map<PacketHeader, ThrowingFunction<byte[], Packet, Exception>> definitions = new HashMap<>();

		for (BeanDefinition packetDefinition : classPathScanner.findCandidateComponents("pl.cwanix.opensun")) {
			Class<? extends Packet> packetClass = (Class<? extends Packet>) Class.forName(packetDefinition.getBeanClassName());

			Constructor<? extends Packet> packetConstructor = getIncomingPacketConstructor(packetClass);
			ThrowingFunction<byte[], Packet, Exception> packetConstructorFunction = packetConstructor::newInstance;

			log.debug(MARKER, "Loaded incoming packet type: {}", packetClass.getSimpleName());

			PacketHeader header = new PacketHeader(packetClass.getAnnotation(IncomingPacket.class).category().getCategory(), packetClass.getAnnotation(IncomingPacket.class).type());
			definitions.put(header, packetConstructorFunction);
		}

		return definitions;
	}

	@Bean
	@SuppressWarnings("unchecked")
	public void serverPacketDefinitions() throws ClassNotFoundException, PacketException {
		ClassPathScanningCandidateComponentProvider classPathScanner = new ClassPathScanningCandidateComponentProvider(false);
		classPathScanner.addIncludeFilter(new AnnotationTypeFilter(OutgoingPacket.class));

		for (BeanDefinition packetDefinition : classPathScanner.findCandidateComponents("pl.cwanix.opensun")) {
			Class<? extends Packet> packetClass = (Class<? extends Packet>) Class.forName(packetDefinition.getBeanClassName());
			checkOutgoingPacketContract(packetClass);

			log.debug(MARKER, "Loaded outgoing packet type: {}", packetClass.getSimpleName());
		}
	}

	private Constructor<? extends Packet> getIncomingPacketConstructor(Class<? extends Packet> packetClass) throws PacketException {
		try {
			return packetClass.getConstructor(byte[].class);
		} catch (NoSuchMethodException e) {
			throw new PacketException("IncomingPacket should implement constructor with one byte[] argument", e);
		}
	}

	private void checkOutgoingPacketContract(Class<? extends Packet> packetClass) throws PacketException {
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
}
