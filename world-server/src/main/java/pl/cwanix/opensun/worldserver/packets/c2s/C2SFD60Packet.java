package pl.cwanix.opensun.worldserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.worldserver.packets.s2c.S2C486CPacket;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x60)
public class C2SFD60Packet implements Packet {
	
	public C2SFD60Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2C486CPacket());
	}

}
