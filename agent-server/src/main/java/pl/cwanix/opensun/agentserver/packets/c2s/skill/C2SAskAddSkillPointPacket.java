package pl.cwanix.opensun.agentserver.packets.c2s.skill;

import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@Slf4j
@IncomingPacket(category = PacketCategory.SKILL, operation = PacketOPCode.SKILL_ASK_ADD_SKILL_POINT)
public class C2SAskAddSkillPointPacket implements Packet {

    public C2SAskAddSkillPointPacket(final byte[] value) {

    }
}
