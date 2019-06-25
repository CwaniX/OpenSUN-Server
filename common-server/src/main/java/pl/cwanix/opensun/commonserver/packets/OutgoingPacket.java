package pl.cwanix.opensun.commonserver.packets;

public @interface OutgoingPacket {

	PacketCategory category();
	byte type();
}
