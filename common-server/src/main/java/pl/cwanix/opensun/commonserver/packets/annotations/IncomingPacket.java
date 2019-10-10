package pl.cwanix.opensun.commonserver.packets.annotations;

import pl.cwanix.opensun.commonserver.packets.PacketCategory;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IncomingPacket {

	PacketCategory category();
	byte type();
}
