package pl.cwanix.opensun.commonserver.packets;

public class PacketException extends RuntimeException {

    private static final long serialVersionUID = -3420602846775021832L;

    public PacketException(final String message) {
        super(message);
    }

    public PacketException(final String message, final Throwable cause) {
        super(message, cause);
    }

}
