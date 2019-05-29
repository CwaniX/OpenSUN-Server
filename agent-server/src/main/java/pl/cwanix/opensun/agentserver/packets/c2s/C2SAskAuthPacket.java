package pl.cwanix.opensun.agentserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CAnsCharactersListPacket;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskAuthPacket extends ClientPacket {

	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x76);
	
	public C2SAskAuthPacket(byte[] value) {
		
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		S2CAnsCharactersListPacket ansCharactersListPacket = new S2CAnsCharactersListPacket();
		ansCharactersListPacket.process(ctx);
		
		ctx.writeAndFlush(ansCharactersListPacket);
	}
}
