package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvListPacket;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvStatePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@IncomingPacket
public class C2SAskSrvListPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x0F);
	
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
