package pl.cwanix.opensun.agentserver.engine.maps;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ZoneType {
    VILLAGE(1);

    private int type;

    public byte getType() {
        return (byte) this.type;
    }

    public boolean equals(int value) {
        return type == value;
    }

    public boolean equals(ZoneType value) {
        return type == value.getType();
    }
}
