package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvListPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskSrvListPacket extends ClientPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x0F);
	
	public C2SAskSrvListPacket(byte[] size, byte[] value) {

	}
	
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsSrvListPacket());
	}
}
