package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x2B)
public class C2SAskMovePacket implements Packet {
	
	private Vector currentPosition;
	private FixedLengthField angle;
	private FixedLengthField tileIndex;
	private FixedLengthField moveState;
	
	public C2SAskMovePacket(byte[] value) {
		currentPosition = new Vector(value);
		angle = new FixedLengthField(2);
		tileIndex = new FixedLengthField(2);
		moveState = new FixedLengthField(1);
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
