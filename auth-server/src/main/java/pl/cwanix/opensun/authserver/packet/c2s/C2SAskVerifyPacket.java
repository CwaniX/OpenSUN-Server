package pl.cwanix.opensun.authserver.packet.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsVerifyPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x01)
public class C2SAskVerifyPacket implements Packet {
	
	private FixedLengthField clientVersion;
	private FixedLengthField clientIpAddress;
	
	public C2SAskVerifyPacket(byte[] value) {
		this.clientVersion = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.clientIpAddress = new FixedLengthField(16, Arrays.copyOfRange(value, 4, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsVerifyPacket());
	}
}
