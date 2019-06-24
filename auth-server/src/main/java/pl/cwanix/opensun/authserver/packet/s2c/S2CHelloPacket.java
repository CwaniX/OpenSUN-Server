package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@Slf4j
@Getter
@OutgoingPacket
public class S2CHelloPacket extends Packet {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x33, (byte) 0x00);
	
	private FixedLengthField serverInfo;
	private FixedLengthField encKey;
	
	public S2CHelloPacket() {
		this.serverInfo = new FixedLengthField(64);
		this.encKey = new FixedLengthField(4);
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
		encKey.setValue(session.getEncKey());
	}
}
