package pl.cwanix.opensun.commonserver.packets;

public class PacketException extends Exception {

	private static final long serialVersionUID = -3420602846775021832L;
	
    public PacketException(String message) {
        super(message);
    }
	
    public PacketException(String message, Throwable cause) {
        super(message, cause);
    }

}
