package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@Getter
@Setter
public class ItemPartPacketStructure implements PacketStructure {
	
	private FixedLengthField code; //2
	private FixedLengthField durability; //1
	private FixedLengthField serial; //4

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}
}
