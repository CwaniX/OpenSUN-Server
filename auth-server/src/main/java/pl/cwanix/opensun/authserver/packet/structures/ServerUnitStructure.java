package pl.cwanix.opensun.authserver.packet.structures;

import org.apache.commons.lang3.ArrayUtils;

import lombok.Getter;
import pl.cwanix.opensun.authserver.entities.ServerEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
public class ServerUnitStructure implements PacketStructure {

	private FixedLengthField serverName;
	private FixedLengthField serverId;
	private FixedLengthField unknown;
	
	public ServerUnitStructure(ServerEntity server) {
		this.serverName = new FixedLengthField(32, server.getName());
		this.serverId = new FixedLengthField(1, server.getId());
		this.unknown = new FixedLengthField(1, 0x01);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serverName, serverId, unknown);
	}
}
