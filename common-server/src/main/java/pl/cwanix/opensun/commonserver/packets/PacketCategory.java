package pl.cwanix.opensun.commonserver.packets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PacketCategory {

    AUTH(0x33),
    CONNECTION(0x48),
    CHARACTER(0xA5),
    SYNC(0xFD),
    SKILL(0xC8),
    STATUS(0x59),
    UNKNOWN(0xEA),
    ZONE(0x6F),
    ITEM(0x21);

    private final int category;

    public byte getCategory() {
        return (byte) this.category;
    }
}
