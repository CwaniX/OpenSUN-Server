package pl.cwanix.opensun.agentserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CA52APacket;
import pl.cwanix.opensun.agentserver.packets.s2c.S2CA5C1Packet;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskSelectCharPacket extends ClientPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0x1F);
	
	public C2SAskSelectCharPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		//ctx.writeAndFlush(new S2CA52APacket());
		ctx.writeAndFlush(new S2CA5C1Packet());
	}

}
