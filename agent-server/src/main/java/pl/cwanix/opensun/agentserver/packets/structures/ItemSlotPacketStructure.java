package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
public class ItemSlotPacketStructure implements PacketStructure {

    private final FixedLengthField position;
    private final ItemPartPacketStructure itemPart;
    private final OptionPartPacketStructure optionPart;

    public ItemSlotPacketStructure(final byte[] value) {
        position = new FixedLengthField(1, value[0]);
        itemPart = new ItemPartPacketStructure(Arrays.copyOfRange(value, 1, 8));
        optionPart = new OptionPartPacketStructure(Arrays.copyOfRange(value, 8, value.length));
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(position, itemPart, optionPart);
    }
}
