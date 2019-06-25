package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@OutgoingPacket(category = PacketCategory.CONNECTION, type = 0x15)
public class S2CAnsWorldConnectPacket extends Packet {

	private FixedLengthField worldServerIp;
	private FixedLengthField worldServerPort;
	//private FixedLengthField unknownValue;

	public S2CAnsWorldConnectPacket() {
		worldServerIp = new FixedLengthField(32);
		worldServerPort = new FixedLengthField(2);
		//unknownValue = new FixedLengthField(4, new byte[] { 0x02, 0x00, 0x48, (byte) 0xdf });
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		worldServerIp.setValue(properties.getWorld().getIp());
		worldServerPort.setValue(properties.getWorld().getPort());
	}
}
