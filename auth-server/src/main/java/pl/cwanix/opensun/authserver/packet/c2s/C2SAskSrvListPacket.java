package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvListPacket;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvStatePacket;
import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x0F)
public class C2SAskSrvListPacket implements Packet<AuthServerContext> {
	
	public C2SAskSrvListPacket(byte[] value) {

	}
	
	@Override
	public void process(ChannelHandlerContext ctx, AuthServerContext srv) {		
		ctx.writeAndFlush(new S2CAnsSrvListPacket());
		ctx.writeAndFlush(new S2CAnsSrvStatePacket());
	}
}
