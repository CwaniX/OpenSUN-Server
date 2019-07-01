package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;
import pl.cwanix.opensun.utils.datatypes.SUNDataType;

public interface Packet extends PacketStructure {
	
	public void process(ChannelHandlerContext ctx);
	
	@Override
	@SuppressWarnings("unchecked")
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
		
		for (Field field : this.getClass().getDeclaredFields()) {			
			if (ArrayUtils.contains(field.getType().getInterfaces(), SUNDataType.class)) {
				SUNDataType fieldValue = (SUNDataType) FieldUtils.readField(field, this, true);
				
				baos.write(fieldValue.toByteArray());
			} else if (ArrayUtils.contains(field.getType().getInterfaces(), Collection.class)) {
				List<PacketStructure> fieldValue = (List<PacketStructure>) FieldUtils.readField(field, this, true);
				
				for (PacketStructure value : fieldValue) {
					baos.write(value.toByteArray());
				}
			}
		}
		
		return baos.toByteArray();
	}
}
