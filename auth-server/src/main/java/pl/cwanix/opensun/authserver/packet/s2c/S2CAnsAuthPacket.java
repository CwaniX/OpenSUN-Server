package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsAuthPacket extends Packet {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x0E);
	
	private FixedLengthField result;
	private FixedLengthField info;
	
	public S2CAnsAuthPacket() {
		this.result = new FixedLengthField(1);
		this.info = new FixedLengthField(64);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {

	}
	
	@Override
	public byte[] toByteArray() {
		return BytesUtils.mergeArrays(PACKET_ID.getValue(), result.getValue(), info.getValue());
	}
	
	public void setResult(byte resultCode) {
		result.setValue(resultCode);
	}
}
