package pl.cwanix.opensun.agentserver.packets.c2s.skill;

import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@Slf4j
@IncomingPacket(category = PacketCategory.SKILL, type = (byte) 0xC5)
public class C2SAskAddSkillPointPacket implements Packet {

	public C2SAskAddSkillPointPacket(byte[] value) {

	}
}
