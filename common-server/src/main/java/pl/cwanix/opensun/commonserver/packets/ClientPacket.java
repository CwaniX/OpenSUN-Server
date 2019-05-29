package pl.cwanix.opensun.commonserver.packets;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
public abstract class ClientPacket extends Packet {
	
	private SUNSession session;
	private RestTemplate restTemplate;

	public abstract void process(ChannelHandlerContext ctx);
}
