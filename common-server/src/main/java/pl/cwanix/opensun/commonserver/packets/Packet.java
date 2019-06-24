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
	
	public static final PacketHeader PACKET_ID = new PacketHeader((byte) 0x00, (byte) 0x00);
	
	public abstract void process(ChannelHandlerContext ctx);
	public byte[] toByteArray() throws Exception {		
		PacketHeader currentHeader = (PacketHeader) this.getClass().getDeclaredField("PACKET_ID").get(null);
		
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
