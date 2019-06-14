package pl.cwanix.opensun.agentserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsPingPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x15);

	private FixedLengthField worldServerIp;
	private FixedLengthField worldServerPort;
	private FixedLengthField unknownValue;

	public S2CAnsPingPacket() {
		worldServerIp = new FixedLengthField(32);
		worldServerPort = new FixedLengthField(2);
		unknownValue = new FixedLengthField(4, new byte[] { 0x02, 0x00, 0x48, (byte) 0xdf });
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), worldServerIp.getValue(), worldServerPort.getValue(), unknownValue.getValue());
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerProperties properties = ctx.channel().attr(AgentServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		worldServerIp.setValue(properties.getWorld().getIp());
		worldServerPort.setValue(properties.getWorld().getPort());
	}
}
