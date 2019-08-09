package pl.cwanix.opensun.authserver.packet.s2c;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.entities.ServerEntity;
import pl.cwanix.opensun.authserver.packet.structures.ServerUnitStructure;
import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x11)
public class S2CAnsSrvListPacket implements Packet<AuthServerContext> {

	private FixedLengthField serversCount;
	private List<ServerUnitStructure> serverList;
	
	public S2CAnsSrvListPacket() {
		this.serversCount = new FixedLengthField(1);
		this.serverList = new ArrayList<>();
	}

	@Override
	public void process(ChannelHandlerContext ctx, AuthServerContext srv) {		
		List<ServerEntity> servers = srv.getDbConnector().findServers();

		serversCount.setValue(servers.size());
		servers.stream().forEach(server -> serverList.add(new ServerUnitStructure(server)));
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serversCount, serverList);
	}
}
