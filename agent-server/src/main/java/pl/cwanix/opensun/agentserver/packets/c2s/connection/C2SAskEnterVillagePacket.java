package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CA5DBPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharItemsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharStylePacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsQuickPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsSkillsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsEnterVillagePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x1F)
public class C2SAskEnterVillagePacket implements Packet {
	
	private FixedLengthField selectedChar;
	
	public C2SAskEnterVillagePacket(byte[] value) {
		selectedChar = new FixedLengthField(1, value[0]);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsCharItemsPacket());
		ctx.writeAndFlush(new S2CAnsSkillsPacket());
		ctx.writeAndFlush(new S2CAnsQuickPacket());
		ctx.writeAndFlush(new S2CAnsCharStylePacket());
		ctx.writeAndFlush(new S2CA5DBPacket());
		ctx.writeAndFlush(new S2CAnsEnterVillagePacket());
	}
}
