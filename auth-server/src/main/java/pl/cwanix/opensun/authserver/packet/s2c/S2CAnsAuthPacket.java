package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x0E)
public class S2CAnsAuthPacket implements Packet {
	
	private FixedLengthField result;
	private FixedLengthField info;
	
	public S2CAnsAuthPacket() {
		this.result = new FixedLengthField(1);
		this.info = new FixedLengthField(64);
	}

	public void process(ChannelHandlerContext ctx) {

	}
	
	public void setResult(byte resultCode) {
		result.setValue(resultCode);
	}
}
