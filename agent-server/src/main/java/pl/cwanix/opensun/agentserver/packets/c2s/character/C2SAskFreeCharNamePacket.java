package pl.cwanix.opensun.agentserver.packets.c2s.character;

import io.netty.channel.ChannelHandlerContext;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;

@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CHAR_INFO, type = 0x51)
public class C2SAskFreeCharNamePacket extends Packet {
	
	public C2SAskFreeCharNamePacket(byte[] value) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}
}
