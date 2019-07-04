package pl.cwanix.opensun.agentserver.packets.s2c.sync;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ZONE, type = 0x6C)
public class S2CAnsVillageMovePacket implements Packet {
	
	private FixedLengthField villageMapCode;
	private FixedLengthField moveType;
	
	public S2CAnsVillageMovePacket(short mapCode, int type) {
		villageMapCode = new FixedLengthField(2, mapCode);
		moveType = new FixedLengthField(4, type);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
