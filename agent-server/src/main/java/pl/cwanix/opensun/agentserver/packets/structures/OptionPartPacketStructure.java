package pl.cwanix.opensun.agentserver.packets.structures;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;

public class OptionPartPacketStructure implements PacketStructure {
	
	private byte[] value;
	
	public OptionPartPacketStructure(byte[] value) {
		this.value = value;
	}
	
	@Override
	public byte[] toByteArray() {
		return value;
	}
}
