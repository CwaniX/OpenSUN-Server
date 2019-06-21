package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@OutgoingPacket
public class S2CAnsVerifyPacket extends Packet {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x02);
	
	private FixedLengthField result;
	
	public S2CAnsVerifyPacket() {
		this.result = new FixedLengthField(1, (byte) 0x00);
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {

	}
}
