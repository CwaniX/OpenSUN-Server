package pl.cwanix.opensun.agentserver.packets.structures;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@SuppressWarnings("checkstyle:MagicNumber")
public class RenderItemPartPacketStructure implements PacketStructure {

    private final FixedLengthField code;
    private final FixedLengthField enchant;
    private final FixedLengthField durability;

    public RenderItemPartPacketStructure(final byte[] value) {
        code = new FixedLengthField(2, value[0], value[1]);
        enchant = new FixedLengthField(1, value[2]);
        durability = new FixedLengthField(1, value[3]);
    }

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(code, enchant, durability);
    }
}
