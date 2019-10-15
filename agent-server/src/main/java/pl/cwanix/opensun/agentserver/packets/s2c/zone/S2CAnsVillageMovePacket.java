package pl.cwanix.opensun.agentserver.packets.s2c.zone;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.ZONE, type = 0x6C)
public class S2CAnsVillageMovePacket implements Packet {
	
	private FixedLengthField moveType;
	private FixedLengthField villageMapCode;
	
	public S2CAnsVillageMovePacket(short mapCode, int type) {
		/*try {
			byte[] data = DatatypeConverter.parseHexBinary(new String(Files.readAllBytes(Paths.get("G:\\Projekty\\SUN\\ose-data\\temp\\input.txt")), "UTF-8"));
			
			moveType = new FixedLengthField(data.length, data);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		//moveType = new FixedLengthField(2, type);
		villageMapCode = new FixedLengthField(2, mapCode);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(villageMapCode);
	}
}
