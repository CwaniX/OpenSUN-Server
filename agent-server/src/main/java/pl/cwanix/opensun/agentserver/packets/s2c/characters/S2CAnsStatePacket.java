package pl.cwanix.opensun.agentserver.packets.s2c.characters;

import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.agentserver.packets.structures.StateSlotPacketStructure;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = PacketCategory.CHARACTER, operation = PacketOPCode.CHARACTER_ANS_STATE)
public class S2CAnsStatePacket implements Packet {

    private final FixedLengthField count;
    private final List<StateSlotPacketStructure> slot;

    public S2CAnsStatePacket() {
        this.count = new FixedLengthField(1, 0x02);
        this.slot = new ArrayList<>();
        this.slot.add(new StateSlotPacketStructure(new byte[] {0x01, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00}));
        this.slot.add(new StateSlotPacketStructure(new byte[] {0x02, 0x00, (byte) 0xe8, 0x03, 0x00, 0x00}));
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(count, slot);
    }
}
