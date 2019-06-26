package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvListPacket;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvStatePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x0F)
public class C2SAskSrvListPacket implements Packet {
	
	public C2SAskSrvListPacket(byte[] value) {

	}
	
	public void process(ChannelHandlerContext ctx) {
		S2CAnsSrvListPacket ansSrvListPacket = new S2CAnsSrvListPacket();
		ansSrvListPacket.process(ctx);
		
		S2CAnsSrvStatePacket ansSrvStatePacket = new S2CAnsSrvStatePacket();
		ansSrvStatePacket.process(ctx);
		
		ctx.writeAndFlush(ansSrvListPacket);
		ctx.writeAndFlush(ansSrvStatePacket);
	}
}
