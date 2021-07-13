package pl.cwanix.opensun.commonserver.packets.c2s;

import lombok.Getter;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

@Getter
public class C2SAskUnknownPacket implements Packet {

    private final PacketHeader id;
    private final byte[] value;

    public C2SAskUnknownPacket(final PacketHeader id, final byte[] value) {
        this.id = id;
        this.value = value;
    }
}
