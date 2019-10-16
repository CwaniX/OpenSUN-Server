package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x8D)
public class C2SAskPlayerEnterPacket implements Packet {
	
	private FixedLengthField checkSum;
	
	public C2SAskPlayerEnterPacket(byte[] value) {
		checkSum = new FixedLengthField(16, value);
	}
}
