package pl.cwanix.opensun.authserver.packet.s2c;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.server.AuthServerChannelHandler;
import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.authserver.server.session.AuthServerSession;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x1A)
public class S2CAnsSrvSelectPacket implements Packet<AuthServerContext> {

	private FixedLengthField userId;
	private FixedLengthField unknownString;
	private FixedLengthField serverIp;
	private FixedLengthField serverPort;

	public S2CAnsSrvSelectPacket() {
		userId = new FixedLengthField(4);
		unknownString = new FixedLengthField(32, new byte[] { 0x30, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, (byte) 0x81, 0x07, 0x20, 0x42, 0x00, 0x20, 0x0f, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x00, 0x00, 0x20, 0x0e, 0x00, 0x20, 0x07, 0x08 });
		serverIp = new FixedLengthField(32, new byte[] { 0x31, 0x39, 0x32, 0x2e, 0x31, 0x36, 0x38, 0x2e, 0x30, 0x2e, 0x31, 0x36, 0x34 });
		serverPort = new FixedLengthField(5, new byte[] { 0x76, (byte) 0xad, 0x00, 0x00, 0x00 });
	}

	@Override
	public void process(ChannelHandlerContext ctx, AuthServerContext srv) {
		AuthServerSession session = ctx.channel().attr(AuthServerChannelHandler.SESSION_ATTRIBUTE).get();
		userId.setValue(session.getUser().getId());
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(userId, unknownString, serverIp, serverPort);
	}
}
