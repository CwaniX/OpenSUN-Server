package pl.cwanix.opensun.agentserver.packets.c2s.character;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.Arrays;

@SuppressWarnings("checkstyle:MagicNumber")
@Slf4j
@Getter
@IncomingPacket(category = PacketCategory.CHARACTER, operation = PacketOPCode.CHARACTER_ASK_CREATE_CHAR)
public class C2SAskCreateCharPacket implements Packet {

    private final FixedLengthField classCode;
    private final FixedLengthField charName;
    private final FixedLengthField heightCode;
    private final FixedLengthField faceCode;
    private final FixedLengthField hairCode;

    public C2SAskCreateCharPacket(final byte[] value) {
        this.classCode = new FixedLengthField(1, value[15]);
        this.charName = new FixedLengthField(16, Arrays.copyOfRange(value, 20, 37));
        this.heightCode = new FixedLengthField(1, value[37]);
        this.faceCode = new FixedLengthField(1, value[38]);
        this.hairCode = new FixedLengthField(1, value[39]);
    }
}
