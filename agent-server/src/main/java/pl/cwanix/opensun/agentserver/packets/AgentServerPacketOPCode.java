package pl.cwanix.opensun.agentserver.packets;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AgentServerPacketOPCode {

    public static class Connection {
        public static final byte CATEGORY = 0x48;

        public static class Ask {
            public static final byte ENTER_SERVER = 0x76;
            public static final byte ENTER_VILLAGE = 0x1F;
            public static final byte WORLD_CONNECT = (byte) 0xDF;
        }

        public static class Ans {
            public static final byte WORLD_CONNECT = 0x15;
            public static final byte ENTER_VILLAGE = (byte) 0x83;
            public static final byte ENTER_SERVER = (byte) 0x98;
        }
    }

    public static class Character {
        public static final byte CATEGORY = (byte) 0xA5;

        public static class Ask {
            public static final byte FREE_CHAR_NAME = 0x51;
            public static final byte CREATE_CHAR = 0x6F;
            public static final byte DELETE_CHAR = (byte) 0x89;
        }

        public static class Ans {
            public static final byte DELETE_CHAR = 0x07;
            public static final byte ITEMS = 0x2A;
            public static final byte SKILLS = (byte) 0x9F;
            public static final byte QUICK = (byte) 0xBE;
            public static final byte STYLE = (byte) 0xC1;
            public static final byte STATE = (byte) 0xDB;
            public static final byte CREATE_CHAR = (byte) 0xE2;
        }

        public static class Err {
            public static final byte CREATE_CHAR = 0x71;
        }
    }

    public static class Item {
        public static final byte CATEGORY = 0x21;

        public static class Ask {
            public static final byte QUICK_LINK_SKILL = (byte) 0xC0;
        }

        public static class Ans {
            public static final byte QUICK_LINK_SKILL = (byte) 0xF7;
        }

        public static class Err {
            public static final byte QUICK_LINK_SKILL = 0x10;
        }
    }

    public static class Skill {
        public static final byte CATEGORY = (byte) 0xC8;

        public static class Ask {
            public static final byte ADD_SKILL_POINT = (byte) 0xC5;
        }
    }

    public static class Status {
        public static final byte CATEGORY = 0x59;

        public static class Ask {
            public static final byte STAT_SELECT = 0x3C;
        }

        public static class Ans {
            public static final byte RECOVER_ATTR = 0x10;
            public static final byte RECOVER_ATTR_MP = 0x32;
            public static final byte STAT_SELECT = 0x7D;
        }

        public static class Err {
            public static final byte STAT_SELECT = 0x7E;
        }
    }

    public static class Sync {
        public static final byte CATEGORY = (byte) 0xFD;

        public static class Ask {
            public static final byte JUMP_MOVE = 0x73;
            public static final byte KEYBOARD_MOVE = 0x2B;
            public static final byte MOUSE_MOVE = (byte) 0xCA;
            public static final byte PLAYER_ENTER = (byte) 0x8D;
        }

        public static class Ans {
            public static final byte ALL_PLAYERS_EQUIP_INFO = 0x0F;
            public static final byte PLAYER_ENTER = 0x1F;
            public static final byte ALL_PLAYERS_GUILD_INFO = (byte) 0xEA;
        }
    }

    public static class Unknown {
        public static final byte CATEGORY = (byte) 0xEA;

        public static class Unk {
            public static final byte _EA09 = 0x09;
        }
    }

    public static class Zone {
        public static final byte CATEGORY = (byte) 0x6F;

        public static class Ask {
            public static final byte VILLAGE_MOVE = (byte) 0xCC;
        }

        public static class Ans {
            public static final byte VILLAGE_MOVE = 0x6C;
        }

        public static class Err {
            public static final byte VILLAGE_MOVE = 0X6D;
        }
    }
}
