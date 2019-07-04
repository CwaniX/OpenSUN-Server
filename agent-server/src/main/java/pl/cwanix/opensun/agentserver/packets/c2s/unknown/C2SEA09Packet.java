package pl.cwanix.opensun.agentserver.packets.c2s.unknown;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CAnsRecoverAttrMpPacket;
import pl.cwanix.opensun.agentserver.packets.s2c.status.S2CAnsRecoverAttrPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@IncomingPacket(category = PacketCategory.UNKNOWN, type = (byte) 0x09)
public class C2SEA09Packet implements Packet {
	
	public C2SEA09Packet(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		ctx.writeAndFlush(new S2CAnsRecoverAttrPacket());
		ctx.writeAndFlush(new S2CAnsRecoverAttrMpPacket());
	}

}
