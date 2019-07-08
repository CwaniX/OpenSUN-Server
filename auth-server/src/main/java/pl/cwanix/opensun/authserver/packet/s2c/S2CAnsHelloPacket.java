package pl.cwanix.opensun.authserver.packet.s2c;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x00)
public class S2CAnsHelloPacket implements Packet {
	
	private FixedLengthField serverInfo;
	private FixedLengthField encKey;
	
	public S2CAnsHelloPacket() {
		this.serverInfo = new FixedLengthField(64);
		this.encKey = new FixedLengthField(4);
	}
	
	@Override
	public void process(ChannelHandlerContext ctx) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
		encKey.setValue(session.getEncKey());
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(serverInfo, encKey);
	}
}
