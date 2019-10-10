package pl.cwanix.opensun.commonserver.packets.annotations;

import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface PacketProcessor {

	Class packetClass();
}
