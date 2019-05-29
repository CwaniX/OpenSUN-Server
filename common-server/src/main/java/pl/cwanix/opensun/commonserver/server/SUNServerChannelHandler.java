package pl.cwanix.opensun.commonserver.server;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.AttributeKey;
import pl.cwanix.opensun.commonserver.session.SUNSession;

public class SUNServerChannelHandler extends ChannelInboundHandlerAdapter {
	
	public static final AttributeKey<SUNSession> SESSION_ATTRIBUTE = AttributeKey.valueOf("session");
	public static final AttributeKey<RestTemplate> REST_TEMPLATE_ATTRIBUTE = AttributeKey.valueOf("resttemplate");

    /**
     * Close the connection when an exception is raised.
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
