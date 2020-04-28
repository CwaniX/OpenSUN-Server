package pl.cwanix.opensun.authserver.packet.structures;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;
import pl.cwanix.opensun.authserver.entities.ServerEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
public class ServerUnitStructure implements PacketStructure {

	private FixedLengthField serverName;
	private FixedLengthField unknown1;
	private FixedLengthField serverId;
	private FixedLengthField unknown2;
	
	public ServerUnitStructure(ServerEntity server) {
		this.serverName = new FixedLengthField(32, server.getName());
		this.unknown1 = new FixedLengthField(1);
		this.serverId = new FixedLengthField(1, server.getId());
		this.unknown2 = new FixedLengthField(2);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serverName, unknown1, serverId, unknown2);
	}
}
