package pl.cwanix.opensun.commonserver.packets;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OutgoingPacket {

	PacketCategory category();
	byte type();
}
