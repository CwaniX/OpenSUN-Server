package pl.cwanix.opensun.authserver.packet.s2c;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.entities.ServerEntity;
import pl.cwanix.opensun.authserver.packet.structures.ServerUnitStructure;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x11)
public class S2CAnsSrvListPacket implements Packet {

	private FixedLengthField serversCount;
	private List<ServerUnitStructure> serverList;
	
	public S2CAnsSrvListPacket() {
		this.serversCount = new FixedLengthField(1);
		this.serverList = new ArrayList<>();
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		RestTemplate restTemplate = ctx.channel().attr(AuthServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AuthServerProperties properties = ctx.channel().attr(AuthServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		List<ServerEntity> servers = restTemplate.exchange(properties.getDb().getServerUrl() + "/server/findAll", HttpMethod.GET, null, new ParameterizedTypeReference<List<ServerEntity>>(){}).getBody();

		serversCount.setValue(servers.size());
		servers.stream().forEach(server -> serverList.add(new ServerUnitStructure(server)));
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serversCount, serverList);
	}
}
