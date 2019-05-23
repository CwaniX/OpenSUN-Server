package pl.cwanix.opensun.authserver.packet.c2s;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsAuthPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.encryption.TEA;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Getter
public class C2SAskAuthPacket extends ClientPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x03);
	
	private FixedLengthField userId;
	private FixedLengthField login;
	private FixedLengthField unknown1;
	private FixedLengthField password;
	private FixedLengthField unknown2;
	
	public C2SAskAuthPacket(byte[] size, byte[] value) {
		this.userId = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.login = new FixedLengthField(50, Arrays.copyOfRange(value, 4, 54));
		this.unknown1 = new FixedLengthField(FixedLengthField.BYTE, value[54]);
		this.password = new FixedLengthField(16, Arrays.copyOfRange(value, 55, 71));
		this.unknown2 = new FixedLengthField(8, Arrays.copyOfRange(value, 71, value.length));
	}
	
	public void process(ChannelHandlerContext ctx) {
		byte[] decodedPass = TEA.passwordDecode(password.getValue(), new byte[] { 0, 0, 0, 0 });
		System.out.println(new String(decodedPass));
		
		ctx.writeAndFlush(new S2CAnsAuthPacket());
	}
}
