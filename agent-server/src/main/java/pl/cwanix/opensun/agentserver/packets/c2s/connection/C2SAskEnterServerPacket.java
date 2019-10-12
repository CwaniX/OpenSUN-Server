package pl.cwanix.opensun.agentserver.packets.c2s.connection;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CONNECTION, type = 0x76)
public class C2SAskEnterServerPacket implements Packet {
	
	private FixedLengthField userId;
	private FixedLengthField userName;
	
	public C2SAskEnterServerPacket(byte[] value) {
		this.userId = new FixedLengthField(4, Arrays.copyOfRange(value, 2, 6));
		this.userName = new FixedLengthField(50, Arrays.copyOfRange(value, 7, 54));
	}
}
