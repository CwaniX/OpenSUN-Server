package pl.cwanix.opensun.agentserver.packets.c2s.sync;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;
import pl.cwanix.opensun.utils.datatypes.Vector;

import java.util.Arrays;

@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.SYNC, type = (byte) 0x2B)
public class C2SAskKeyboardMovePacket implements Packet {

	private Vector currentPosition;
	private FixedLengthField angle;
	private FixedLengthField tileIndex;
	private FixedLengthField moveState;
	
	public C2SAskKeyboardMovePacket(byte[] value) {
		currentPosition = new Vector(value);
		angle = new FixedLengthField(2, value[12], value[13]);
		tileIndex = new FixedLengthField(2, value[14], value[15]);
		moveState = new FixedLengthField(1, value[16]);
	}
}
