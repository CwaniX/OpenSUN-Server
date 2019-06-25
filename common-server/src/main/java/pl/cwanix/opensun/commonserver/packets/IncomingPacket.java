package pl.cwanix.opensun.commonserver.packets;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IncomingPacket {

	PacketCategory category();
	byte type();
}
