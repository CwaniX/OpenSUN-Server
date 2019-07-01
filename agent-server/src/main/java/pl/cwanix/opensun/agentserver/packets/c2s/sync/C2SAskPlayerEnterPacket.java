package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersEquipInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersGuildInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsPlayerEnterPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x8D)
public class C2SAskPlayerEnterPacket implements Packet {
	
	public C2SAskPlayerEnterPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsPlayerEnterPacket());
		ctx.writeAndFlush(new S2CAnsAllPlayersGuildInfoPacket());
		ctx.writeAndFlush(new S2CAnsAllPlayersEquipInfoPacket());
	}

}
