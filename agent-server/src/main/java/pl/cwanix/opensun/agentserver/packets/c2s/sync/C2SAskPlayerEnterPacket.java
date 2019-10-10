package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersEquipInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsAllPlayersGuildInfoPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.sync.S2CAnsPlayerEnterPacket;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x8D)
public class C2SAskPlayerEnterPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField checkSum;
	
	public C2SAskPlayerEnterPacket(byte[] value) {
		checkSum = new FixedLengthField(16, value);
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		ctx.writeAndFlush(new S2CAnsPlayerEnterPacket());
		ctx.writeAndFlush(new S2CAnsAllPlayersGuildInfoPacket());
		ctx.writeAndFlush(new S2CAnsAllPlayersEquipInfoPacket());
	}

}
