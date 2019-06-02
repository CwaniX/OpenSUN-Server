package pl.cwanix.opensun.agentserver.packets.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ClientPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class C2SAskFreeCharNamePacket extends ClientPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0x51);
	
	public C2SAskFreeCharNamePacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
