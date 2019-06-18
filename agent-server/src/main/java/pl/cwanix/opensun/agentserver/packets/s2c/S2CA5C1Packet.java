package pl.cwanix.opensun.agentserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CA5C1Packet extends ServerPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xC1);
	
	private byte[] value = { 0x21, 0x00, 0x00, 0x00, 0x00, 0x0f,
			0x00, (byte) 0xa5, (byte) 0xdb, 0x02, 0x01, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00, 0x02, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00,
			0x0a, 0x00, 0x48, (byte) 0x83, 0x10, 0x02, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00
	};

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
