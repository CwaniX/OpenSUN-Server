package pl.cwanix.opensun.agentserver.packets.s2c;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.ServerPacket;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public class S2CAnsCreateNewCharPacket extends ServerPacket {
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xE2);
	
	public S2CAnsCreateNewCharPacket() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public byte[] toByteArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
