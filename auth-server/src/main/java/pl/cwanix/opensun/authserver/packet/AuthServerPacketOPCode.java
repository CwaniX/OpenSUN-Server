package pl.cwanix.opensun.authserver.packet;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthServerPacketOPCode {

    public static class Auth {
        public static final byte CATEGORY = 0x33;

        public static class Ask {
            public static final byte VERIFY = 0x01;
            public static final byte AUTH = 0x03;
            public static final byte SRV_LIST = 0x0F;
            public static final byte SRV_SELECT = 0x13;
        }

        public static class Ans {
            public static final byte HELLO = 0x00;
            public static final byte VERIFY = 0x02;
            public static final byte AUTH = 0x0E;
            public static final byte SRV_LIST = 0x11;
            public static final byte SRV_STATE = 0x12;
            public static final byte SRV_SELECT = 0x1A;
        }
    }
}
