package pl.cwanix.opensun.commonserver.packets;

public abstract class ServerPacket extends Packet {
	
	public byte[] size;

	public abstract byte[] toByteArray();
}
