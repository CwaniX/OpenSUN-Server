package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import pl.cwanix.opensun.utils.datatypes.SUNDataType;

public interface PacketStructure extends SUNDataType {

	@SuppressWarnings("unchecked")
	public default byte[] toByteArray() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		for (Field field : this.getClass().getDeclaredFields()) {
			if (ArrayUtils.contains(field.getType().getInterfaces(), SUNDataType.class)) {
				SUNDataType fieldValue = (SUNDataType) FieldUtils.readField(field, this, true);
				
				baos.write(fieldValue.toByteArray());
			} else if (ArrayUtils.contains(field.getType().getInterfaces(), List.class)) {
				List<PacketStructure> fieldValue = (List<PacketStructure>) FieldUtils.readField(field, this, true);
				
				for (PacketStructure value : fieldValue) {
					baos.write(value.toByteArray());
				}
			}
		}
		
		return baos.toByteArray();
	}
}
