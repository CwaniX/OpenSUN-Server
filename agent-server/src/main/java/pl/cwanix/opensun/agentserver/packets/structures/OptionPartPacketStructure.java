package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;

@Getter
@Setter
public class OptionPartPacketStructure implements PacketStructure {
	
	@Override
	public byte[] toByteArray() {
		return new byte[] { 0x00, 0x00, 0x00, (byte) 0x80, 0x04, 0x00, (byte) 0xc0, 0x00, 0x00, 0x00, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc, (byte) 0xcc };
	}
}
