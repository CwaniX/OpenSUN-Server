package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.SYNC, type = 0x73)
public class C2SAskJumpMovePacket implements Packet<AgentServerContext> {
	
	public C2SAskJumpMovePacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

}
