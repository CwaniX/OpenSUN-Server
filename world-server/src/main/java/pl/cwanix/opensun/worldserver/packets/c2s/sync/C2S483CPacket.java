package pl.cwanix.opensun.worldserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x3C)
public class C2S483CPacket implements Packet {
	
	public C2S483CPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}
}
