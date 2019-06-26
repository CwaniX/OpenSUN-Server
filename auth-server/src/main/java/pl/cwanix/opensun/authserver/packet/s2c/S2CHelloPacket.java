package pl.cwanix.opensun.authserver.packet.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x00)
public class S2CHelloPacket implements Packet {
	
	public FixedLengthField zserverInfo;
	public FixedLengthField bencKey;
	public FixedLengthField cserverInfo;
	public FixedLengthField dencKey;
	public FixedLengthField serverInfo;
	public FixedLengthField aencKey;
	
	public S2CHelloPacket() {
		this.zserverInfo = new FixedLengthField(64);
		this.bencKey = new FixedLengthField(4);
		this.cserverInfo = new FixedLengthField(64);
		this.dencKey = new FixedLengthField(4);
		this.serverInfo = new FixedLengthField(64);
		this.aencKey = new FixedLengthField(4);
	}
	
	public void process(ChannelHandlerContext ctx) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
		aencKey.setValue(session.getEncKey());
	}
}
