package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = 0x15)
public class S2CAnsWorldConnectPacket implements Packet {

	private FixedLengthField worldServerIp;
	private FixedLengthField worldServerPort;

	public S2CAnsWorldConnectPacket(String ip, int port) {
		this.worldServerIp = new FixedLengthField(32);
		this.worldServerPort = new FixedLengthField(2);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(worldServerIp, worldServerPort);
	}
}
