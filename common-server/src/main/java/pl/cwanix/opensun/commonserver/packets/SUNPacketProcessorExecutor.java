package pl.cwanix.opensun.commonserver.packets;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketProcessor;
import pl.cwanix.opensun.commonserver.packets.processors.C2SAskUnknownProcessor;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Component
public class SUNPacketProcessorExecutor {

    private static final Marker MARKER = MarkerFactory.getMarker("PACKET PROCESSOR EXECUTOR");

    private final Map<Class, SUNPacketProcessor> packetProcessorMap;
    private final C2SAskUnknownProcessor unknownProcessor;

    public SUNPacketProcessorExecutor(final List<SUNPacketProcessor> packetProcessors, C2SAskUnknownProcessor unknownProcessor) {
        this.unknownProcessor = unknownProcessor;
        this.packetProcessorMap = packetProcessors
                .stream()
                .filter(p -> p.getClass().isAnnotationPresent(PacketProcessor.class))
                .collect(Collectors.toMap(p -> p.getClass().getAnnotation(PacketProcessor.class).packetClass(), Function.identity()));

        packetProcessors.stream().forEach(p -> log.debug(MARKER, "Loaded packet processor: {}", p.getClass().getSimpleName()));
    }

    public void process(final ChannelHandlerContext ctx, final Packet packet) {
        Class packetClass = packet.getClass();
        SUNPacketProcessor processor = packetProcessorMap.getOrDefault(packetClass, unknownProcessor);

        processor.process(ctx, packet);
    }

    public SUNPacketProcessor getProcessor(final Class packetClass) {
        return packetProcessorMap.get(packetClass);
    }
}
