package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ZoneType {
    VILLAGE(1);

    private final int type;

    public byte getType() {
        return (byte) this.type;
    }

    public boolean equals(final int value) {
        return type == value;
    }

    public boolean equals(final ZoneType value) {
        return type == value.getType();
    }
}
