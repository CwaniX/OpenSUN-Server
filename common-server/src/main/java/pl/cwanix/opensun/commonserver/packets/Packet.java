package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

public interface Packet extends PacketStructure {
	
	public default void process(ChannelHandlerContext ctx) {
		
	}
	
	@Override
	public default byte[] toByteArray() throws Exception {		
		PacketHeader currentHeader;
		
		if (this.getClass().isAnnotationPresent(IncomingPacket.class)) {
			currentHeader = new PacketHeader(this.getClass().getAnnotation(IncomingPacket.class).category().getCategory(), this.getClass().getAnnotation(IncomingPacket.class).type());
		} else if (this.getClass().isAnnotationPresent(OutgoingPacket.class)) {
			currentHeader = new PacketHeader(this.getClass().getAnnotation(OutgoingPacket.class).category().getCategory(), this.getClass().getAnnotation(OutgoingPacket.class).type());
		} else {
			throw new PacketException("Wrong packet definition!");
		}
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		baos.write(currentHeader.getValue());
		writeFeldValuesToStream(baos);
		
		return baos.toByteArray();
	}
}
