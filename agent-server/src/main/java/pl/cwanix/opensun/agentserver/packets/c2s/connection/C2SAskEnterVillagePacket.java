package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharItemsPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.characters.S2CAnsCharStylePacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x1F)
public class C2SAskEnterVillagePacket extends Packet {
	
	private FixedLengthField selectedChar;
	
	public C2SAskEnterVillagePacket(byte[] value) {
		selectedChar = new FixedLengthField(1, value[0]);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsCharItemsPacket());
		ctx.writeAndFlush(new S2CAnsCharStylePacket());
	}
}
