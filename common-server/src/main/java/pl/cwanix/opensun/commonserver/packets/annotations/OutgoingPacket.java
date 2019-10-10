package pl.cwanix.opensun.commonserver.packets.annotations;

import pl.cwanix.opensun.commonserver.packets.PacketCategory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OutgoingPacket {

	PacketCategory category();
	byte type();
}
