package pl.cwanix.opensun.agentserver.packets.structures;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

public class RenderItemSlotPacketStructure implements PacketStructure {

    private final FixedLengthField position;
    private final RenderItemPartPacketStructure itemPart;

    public RenderItemSlotPacketStructure(final byte[] value) {
        position = new FixedLengthField(1, value[0]);
        itemPart = new RenderItemPartPacketStructure(Arrays.copyOfRange(value, 1, value.length));
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(position, itemPart);
    }
}
