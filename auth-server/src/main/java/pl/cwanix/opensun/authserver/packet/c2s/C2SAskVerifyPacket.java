package pl.cwanix.opensun.authserver.packet.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsVerifyPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Getter
public class C2SAskVerifyPacket extends ClientPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x01);
	
	private FixedLengthField clientVersion;
	private FixedLengthField clientIpAddress;
	
	public C2SAskVerifyPacket(byte[] size, byte[] value) {
		this.clientVersion = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.clientIpAddress = new FixedLengthField(16, Arrays.copyOfRange(value, 4, value.length));
	}

	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsVerifyPacket());
	}
}
