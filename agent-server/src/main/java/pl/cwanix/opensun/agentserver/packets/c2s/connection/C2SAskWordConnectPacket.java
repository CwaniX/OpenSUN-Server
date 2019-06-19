package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.agentserver.packets.s2c.connection.S2CAnsWorldConnectPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.packets.PacketHeader;

@IncomingPacket
public class C2SAskWordConnectPacket extends Packet  {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x48, (byte) 0xdf);
	
	public C2SAskWordConnectPacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		S2CAnsWorldConnectPacket ansPing = new S2CAnsWorldConnectPacket();
		ansPing.process(ctx);
		
		ctx.writeAndFlush(ansPing);
	}

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}

}
