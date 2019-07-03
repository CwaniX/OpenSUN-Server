package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import java.util.Arrays;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.commonserver.packets.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0xCA)
public class C2SAskMouseMovePacket implements Packet {
	
	private FixedLengthField unknown;
	private Vector currentPosition;
	private Vector destinationPosition;
	
	public C2SAskMouseMovePacket(byte[] value) {
		unknown = new FixedLengthField(1, value[0]);
		currentPosition = new Vector(Arrays.copyOfRange(value, 1, 13));
		currentPosition = new Vector(Arrays.copyOfRange(value, 13, value.length));
	}

	@Override
	public void process(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}

}
