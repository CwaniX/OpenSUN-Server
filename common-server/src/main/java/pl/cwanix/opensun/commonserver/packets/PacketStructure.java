package pl.cwanix.opensun.commonserver.packets;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;

import pl.cwanix.opensun.utils.packets.FixedLengthField;

public interface PacketStructure {

	public default byte[] toByteArray() throws Exception {				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

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
