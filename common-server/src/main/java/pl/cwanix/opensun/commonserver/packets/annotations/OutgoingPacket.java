package pl.cwanix.opensun.commonserver.packets.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OutgoingPacket {

    byte category();
    byte operation();
}
