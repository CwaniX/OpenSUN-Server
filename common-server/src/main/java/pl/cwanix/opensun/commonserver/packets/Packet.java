package pl.cwanix.opensun.commonserver.packets;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

import io.netty.channel.ChannelHandlerContext;
import pl.cwanix.opensun.utils.packets.FixedLengthField;
import pl.cwanix.opensun.utils.packets.PacketHeader;

public abstract class Packet {
	
	public abstract void process(ChannelHandlerContext ctx);
	public byte[] toByteArray() throws Exception {
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

		for (PropertyDescriptor descriptor : BeanUtils.getPropertyDescriptors(this.getClass())) {
			if (FixedLengthField.class.equals(descriptor.getPropertyType())) {
				Method getter = descriptor.getReadMethod();
				FixedLengthField field = (FixedLengthField) getter.invoke(this);
				
				baos.write(field.getValue());
			} else if (ArrayUtils.contains(descriptor.getPropertyType().getInterfaces(), PacketStructure.class)) {
				Method getter = descriptor.getReadMethod();
				PacketStructure field = (PacketStructure) getter.invoke(this);
				
				baos.write(field.toByteArray());
			}
		}
		
		return baos.toByteArray();
	}
}
