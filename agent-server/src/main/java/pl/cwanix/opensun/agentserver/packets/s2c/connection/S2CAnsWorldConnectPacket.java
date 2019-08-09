package pl.cwanix.opensun.agentserver.packets.s2c.connection;

import org.apache.commons.lang3.ArrayUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.CONNECTION, type = 0x15)
public class S2CAnsWorldConnectPacket implements Packet<AgentServerContext> {

	private FixedLengthField worldServerIp;
	private FixedLengthField worldServerPort;

	public S2CAnsWorldConnectPacket() {
		worldServerIp = new FixedLengthField(32);
		worldServerPort = new FixedLengthField(2);
	}

	@Override
	public void process(ChannelHandlerContext ctx, AgentServerContext srv) {
		worldServerIp.setValue(srv.getProperties().getWorld().getIp());
		worldServerPort.setValue(srv.getProperties().getWorld().getPort());
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(worldServerIp, worldServerPort);
	}
}
