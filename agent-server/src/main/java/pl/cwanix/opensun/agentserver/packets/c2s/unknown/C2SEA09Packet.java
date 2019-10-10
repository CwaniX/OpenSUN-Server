package pl.cwanix.opensun.agentserver.packets.c2s.unknown;

import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.UNKNOWN, type = (byte) 0x09)
public class C2SEA09Packet implements Packet<AgentServerContext> {
	
	public C2SEA09Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}

}
