package pl.cwanix.opensun.commonserver.packets.annotations;

import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.Packet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface PacketProcessor {

	Class<? extends Packet> packetClass();
}
