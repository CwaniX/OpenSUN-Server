package pl.cwanix.opensun.agentserver.packets.s2c.character;

import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.bytes.BytesUtils;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

@SuppressWarnings("checkstyle:MagicNumber")
@OutgoingPacket(category = AgentServerPacketOPCode.Character.CATEGORY, operation = AgentServerPacketOPCode.Character.Ans.STYLE)
public class S2CAnsStylePacket implements Packet {

    public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0xA5, (byte) 0xC1);

    private final byte[] value = {0x21, 0x00, 0x00, 0x00, 0x00, 0x0f, 0x00};

    @Override
    public byte[] toByteArray() {
        // TODO Auto-generated method stub
        return BytesUtils.mergeArrays(PACKET_ID.getValue(), value);
    }

    @Override
    public Object[] getOrderedFields() {
        return null;
    }
}
