package pl.cwanix.opensun.agentserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsPingPacket extends ServerPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x15);

	private byte[] value;

	public S2CAnsPingPacket() {
		value = new byte[] { 0x31, 0x39, 0x32, 0x2e, 0x31, 0x36, 0x38, 0x2e, 0x30, 0x2e, 0x32, 0x34, 0x00, 0x00, 0x00,
				0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
				0x24, 0x4e, 0x02, 0x00, 0x48, (byte) 0xdf };
	}

	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub

	}

}
