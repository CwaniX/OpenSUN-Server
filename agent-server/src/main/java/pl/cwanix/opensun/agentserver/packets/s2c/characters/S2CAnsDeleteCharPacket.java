package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsDeleteCharPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x07);

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue());
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
