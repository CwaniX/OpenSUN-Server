package pl.cwanix.opensun.commonserver.server;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SUNServerChannelHandler extends ChannelInboundHandlerAdapter {
	
	private static final Marker MARKER = MarkerFactory.getMarker("SUN SERVER");

    /**
     * Close the connection when an exception is raised.
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(MARKER, "An error occured", cause);
        ctx.close();
    }
}
