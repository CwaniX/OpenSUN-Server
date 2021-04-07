package pl.cwanix.opensun.worldserver.packets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WorldServerPacketOPCode {

    public static class Connection {
        public static final byte CATEGORY = 0x48;

        public static class Unk {
            public static final byte UNK_483C = 0X3C;
            public static final byte UNK_4860 = 0x60;
            public static final byte UNK_486C = 0x6C;
        }
    }

    public static class Sync {
        public static final byte CATEGORY = (byte) 0xFD;

        public static class Unk {
            public static final byte UNK_FD60 = 0x60;
        }
    }
}
