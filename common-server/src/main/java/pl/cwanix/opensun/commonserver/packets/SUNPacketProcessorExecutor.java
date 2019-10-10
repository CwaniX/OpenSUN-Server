package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SUNPacketProcessorExecutor {

	private static final Marker MARKER = MarkerFactory.getMarker("PACKET PROCESSOR EXECUTOR");

	private Map<Class, SUNPacketProcessor> packetProcessorMap;

	public SUNPacketProcessorExecutor(List<SUNPacketProcessor> packetProcessors) {
		this.packetProcessorMap = packetProcessors
				.stream()
				.collect(Collectors.toMap(p -> p.getClass().getAnnotation(PacketProcessor.class).packetClass(), Function.identity()));

		packetProcessors.stream().forEach(p -> log.debug(MARKER, "Loaded packet processor: {}", p.getClass().getSimpleName()));
	}

	public void process(ChannelHandlerContext ctx, Packet packet) {
		Class packetClass = packet.getClass();
		SUNPacketProcessor processor = packetProcessorMap.get(packetClass);

		processor.process(ctx, packet);
	}
}
