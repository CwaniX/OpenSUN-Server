package pl.cwanix.opensun.worldserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.worldserver.server.context.WorldServerContext;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = (byte) 0x6C)
public class S2C486CPacket implements Packet<WorldServerContext> {

	@Override
	public void process(ChannelHandlerContext ctx, WorldServerContext srv) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object[] getOrderedFields() {
		return null;
	}
}
