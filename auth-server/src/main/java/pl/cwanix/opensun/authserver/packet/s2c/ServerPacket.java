package pl.cwanix.opensun.authserver.packet.s2c;

import pl.cwanix.opensun.authserver.packet.Packet;

public abstract class ServerPacket extends Packet {
	
	public byte[] size;

	public abstract byte[] toByteArray();
}
