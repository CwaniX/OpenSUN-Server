package pl.cwanix.opensun.agentserver.packets.c2s.character;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CHARACTER, type = (byte) 0x89)
public class C2SAskDeleteCharPacket implements Packet {

	private final FixedLengthField slotNumber;
	private final FixedLengthField deleteWord;
	
	public C2SAskDeleteCharPacket(final byte[] value) {
		this.slotNumber = new FixedLengthField(1, value[0]);
		this.deleteWord = new FixedLengthField(10, Arrays.copyOfRange(value, 1, value.length));
	}
}
