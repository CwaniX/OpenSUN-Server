package pl.cwanix.opensun.agentserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsPingPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskPingPacket extends ClientPacket  {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0xdf);
	
	public C2SAskPingPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		S2CAnsPingPacket ansPing = new S2CAnsPingPacket();
		ansPing.process(ctx);
		
		ctx.writeAndFlush(ansPing);
	}

}
