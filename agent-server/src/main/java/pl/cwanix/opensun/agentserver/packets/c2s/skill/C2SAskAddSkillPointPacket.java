package pl.cwanix.opensun.agentserver.packets.c2s.skill;

import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.agentserver.packets.AgentServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@Slf4j
@IncomingPacket(category = AgentServerPacketOPCode.Skill.CATEGORY, operation = AgentServerPacketOPCode.Skill.Ask.ADD_SKILL_POINT)
public class C2SAskAddSkillPointPacket implements Packet {

    public C2SAskAddSkillPointPacket(final byte[] value) {

    }
}
