package pl.cwanix.opensun.agentserver.packets.c2s.item;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.item.S2CAnsQuickLinkSkillPacket;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@IncomingPacket(category = PacketCategory.ITEM, type = (byte) 0xC0)
public class C2SAskQuickLinkSkillPacket implements Packet<AgentServerContext> {
	
	private FixedLengthField slotCode;
	private FixedLengthField position;

	public C2SAskQuickLinkSkillPacket(byte[] value) {
		this.slotCode = new FixedLengthField(2, 0, 2, value);
		this.position = new FixedLengthField(1, 2, value);
	}
	
	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		ctx.writeAndFlush(new S2CAnsQuickLinkSkillPacket(slotCode.toShort(), position.toByte()));
	}
}
