package pl.cwanix.opensun.authserver.packet.c2s;

import java.util.Arrays;

import org.springframework.web.client.RestTemplate;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.entities.UserEntity;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsAuthPacket;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.encryption.TEA;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x03)
public class C2SAskAuthPacket implements Packet {
	
	private FixedLengthField unknown1;
	private FixedLengthField name;
	private FixedLengthField unknown2;
	private FixedLengthField password;
	private FixedLengthField unknown3;
	
	public C2SAskAuthPacket(byte[] value) {
		this.unknown1 = new FixedLengthField(4, Arrays.copyOfRange(value, 0, 4));
		this.name = new FixedLengthField(50, Arrays.copyOfRange(value, 4, 54));
		this.unknown2 = new FixedLengthField(1, value[54]);
		this.password = new FixedLengthField(16, Arrays.copyOfRange(value, 55, 71));
		this.unknown3 = new FixedLengthField(8, Arrays.copyOfRange(value, 71, value.length));
	}
	
	public void process(ChannelHandlerContext ctx) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
		RestTemplate restTemplate = ctx.channel().attr(AuthServerChannelHandler.REST_TEMPLATE_ATTRIBUTE).get();
		AuthServerProperties properties = ctx.channel().attr(AuthServerChannelHandler.PROPERIES_ATTRIBUTE).get();
		
		String decodedPass = new String(TEA.passwordDecode(password.toByteArray(), session.getEncKey()));
		UserEntity userEntity = restTemplate.getForObject(properties.getDb().getServerUrl() + "/user/findByName?name=" + name.toString(), UserEntity.class);
		S2CAnsAuthPacket ansAuthPacket = new S2CAnsAuthPacket();
		
		if (userEntity == null) {
			ansAuthPacket.setResult((byte) 1);
		} else if (!decodedPass.equals(userEntity.getPassword())) {
			ansAuthPacket.setResult((byte) 2);
		} else if (startAgentServerSession(restTemplate, properties, userEntity.getId()) > 0) {
			ansAuthPacket.setResult((byte) 3);
		} else {
			session.setUser(userEntity);
			ansAuthPacket.setResult((byte) 0);
		}
		
		ctx.writeAndFlush(ansAuthPacket);
	}
	
	private int startAgentServerSession(RestTemplate restTemplate, AuthServerProperties properties, int userId) {
		return restTemplate.postForObject(properties.getAgent().getServerUrl() + "/session/new?userId=" + userId, null, Integer.class);
	}
}
