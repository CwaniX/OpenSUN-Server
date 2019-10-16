package pl.cwanix.opensun.authserver.packet.s2c.auth;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.packet.structures.ServerUnitStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x11)
public class S2CAnsSrvListPacket implements Packet {

	private FixedLengthField serversCount;
	private List<ServerUnitStructure> serverList;
	
	public S2CAnsSrvListPacket(int serversCount, List<ServerUnitStructure> serverList) {
		this.serversCount = new FixedLengthField(1, serversCount);
		this.serverList = serverList;
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serversCount, serverList);
	}
}
