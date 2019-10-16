package pl.cwanix.opensun.agentserver.packets.c2s.unknown;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = PacketCategory.UNKNOWN, type = (byte) 0x09)
public class C2SEA09Packet implements Packet {
	
	public C2SEA09Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}

}
