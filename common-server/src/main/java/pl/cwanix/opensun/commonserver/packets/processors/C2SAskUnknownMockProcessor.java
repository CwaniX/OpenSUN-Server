package pl.cwanix.opensun.commonserver.packets.processors;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.c2s.C2SAskUnknownPacket;

@Component
@ConditionalOnProperty(name="processors.unknown", havingValue="mock")
public class C2SAskUnknownMockProcessor implements C2SAskUnknownProcessor {

    @Override
    public void process(ChannelHandlerContext ctx, C2SAskUnknownPacket packet) {

    }
}
