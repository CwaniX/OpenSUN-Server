package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@OutgoingPacket(category = PacketCategory.CHAR_INFO, type = (byte) 0xC1)
public class S2CAnsCharStylePacket implements Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xC1);
	
	private byte[] value = { 0x21, 0x00, 0x00, 0x00, 0x00, 0x0f,
			0x00, (byte) 0xa5, (byte) 0xdb, 0x02, 0x01, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00, 0x02, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00,
			0x0a, 0x00, 0x48, (byte) 0x83, 0x10, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
	};

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}
}
