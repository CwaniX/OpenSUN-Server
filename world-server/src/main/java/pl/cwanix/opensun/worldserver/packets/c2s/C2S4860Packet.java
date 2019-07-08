package pl.cwanix.opensun.worldserver.packets.c2s;

import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x60)
public class C2S4860Packet implements Packet {
	
	public C2S4860Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}
}
