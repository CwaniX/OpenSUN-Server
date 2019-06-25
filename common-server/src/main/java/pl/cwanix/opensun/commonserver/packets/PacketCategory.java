package pl.cwanix.opensun.commonserver.packets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PacketCategory {

	AUTH(0x33),
	CONNECTION(0x48),
	CHAR_INFO(0xA5),
	SYNC(0xFD);
	
	private int category;
	
	public byte getCategory() {
		return (byte) this.category;
	}
}
