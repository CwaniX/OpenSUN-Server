package pl.cwanix.opensun.authserver.packet.c2s.auth;

import pl.cwanix.opensun.authserver.packet.AuthServerPacketOPCode;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;

@IncomingPacket(category = AuthServerPacketOPCode.Auth.CATEGORY, operation = AuthServerPacketOPCode.Auth.Ask.SRV_LIST)
public class C2SAskSrvListPacket implements Packet {

    public C2SAskSrvListPacket(final byte[] value) {

    }
}
