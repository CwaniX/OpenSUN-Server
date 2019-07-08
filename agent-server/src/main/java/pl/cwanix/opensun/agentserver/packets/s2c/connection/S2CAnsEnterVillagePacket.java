package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.server.AgentServerChannelHandler;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x83)
public class S2CAnsEnterVillagePacket implements Packet {
	
	private FixedLengthField playerKey;
	
	public S2CAnsEnterVillagePacket() {
		playerKey = new FixedLengthField(4);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		AgentServerSession session = ctx.channel().attr(AgentServerChannelHandler.SESSION_ATTRIBUTE).get();
		
		playerKey.setValue(session.getCharacter().getId());
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(playerKey);
	}
}
