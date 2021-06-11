package pl.cwanix.opensun.agentserver.packets.structures;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

import java.util.List;

@RequiredArgsConstructor
public class InventoryTotalInfoPacketStructure implements PacketStructure {

    private final FixedLengthField inventCount; //1 - max 75
    private final FixedLengthField tmpInventCount; //1 - max 20
    private final List<ItemSlotPacketStructure> invent;
    private final List<ItemSlotPacketStructure> tmpInvent;

    @Override
    public Object[] getOrderedFields() {
        return ArrayUtils.toArray(inventCount, tmpInventCount, invent, tmpInvent);
    }
}
