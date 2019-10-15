package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x60)
public class C2SFD60Packet implements Packet {
	
	public C2SFD60Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}
}
