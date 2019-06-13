package pl.cwanix.opensun.agentserver.packets.structures;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;

public class OptionPartPacketStructure implements PacketStructure {
	
	public OptionPartPacketStructure(byte[] value) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public byte[] toByteArray() {
		return new byte[] { 00, 00, 00, 00, 00, 00, (byte) 0xc0, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00 };
	}
}
