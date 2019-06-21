package pl.cwanix.opensun.authserver.packet.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsVerifyPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@IncomingPacket
public class C2SAskVerifyPacket extends Packet {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x01);
	
	private FixedLengthField clientVersion;
	private FixedLengthField clientIpAddress;
	
	public C2SAskVerifyPacket(byte[] value) {
		this.clientVersion = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.clientIpAddress = new FixedLengthField(16, Arrays.copyOfRange(value, 4, value.length));
	}

	public void process(ChannelHandlerContext ctx) {
		S2CAnsVerifyPacket ansVerifyPacket = new S2CAnsVerifyPacket();
		ansVerifyPacket.process(ctx);
		
		ctx.writeAndFlush(ansVerifyPacket);
	}
}
