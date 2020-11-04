package pl.cwanix.opensun.authserver.packet.c2s.auth;

import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.PacketOPCode;

@IncomingPacket(category = PacketCategory.AUTH, operation = PacketOPCode.AUTH_ASK_SRV_LIST)
public class C2SAskSrvListPacket implements Packet {

    public C2SAskSrvListPacket(final byte[] value) {

    }
}
