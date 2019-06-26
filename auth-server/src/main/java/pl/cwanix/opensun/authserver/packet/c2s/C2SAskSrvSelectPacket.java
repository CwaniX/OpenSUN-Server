package pl.cwanix.opensun.authserver.packet.c2s;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.authserver.packet.s2c.S2CAnsSrvSelectPacket;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.packets.FixedLengthField;

@IncomingPacket(category = PacketCategory.AUTH, type = 0x13)
public class C2SAskSrvSelectPacket implements Packet {
	
	private FixedLengthField serverIndex;
	private FixedLengthField channelIndex;
	
	public C2SAskSrvSelectPacket(byte[] value) {
		this.serverIndex = new FixedLengthField(1, value[0]);
		this.channelIndex = new FixedLengthField(1, value[1]);
	}
	
	public void process(ChannelHandlerContext ctx) {
		S2CAnsSrvSelectPacket ansSrvSelect = new S2CAnsSrvSelectPacket();
		ansSrvSelect.process(ctx);
		
		ctx.writeAndFlush(ansSrvSelect);
	}
}
