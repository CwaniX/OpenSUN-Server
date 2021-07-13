package pl.cwanix.opensun.commonserver.packets.processors;

import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.c2s.C2SAskUnknownPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;

@Slf4j
@Component
@ConditionalOnProperty(name="processors.unknown", havingValue="log", matchIfMissing = true)
public class C2SAskUnknownLoggingProcessor implements C2SAskUnknownProcessor {

    private static final Marker MARKER = MarkerFactory.getMarker("C2S -> UNKNOWN");

    @Override
    public void process(ChannelHandlerContext ctx, C2SAskUnknownPacket packet) {
        log.error(MARKER, "Unknown packet: {}", BytesUtils.byteArrayToHexString(packet.getId().getValue()));
    }
}
