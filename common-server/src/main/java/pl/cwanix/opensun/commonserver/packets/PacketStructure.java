package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import pl.cwanix.opensun.utils.packets.FixedLengthField;

public interface PacketStructure {

	@SuppressWarnings("unchecked")
	public default byte[] toByteArray() throws Exception {				
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		for (Field field : this.getClass().getDeclaredFields()) {
			if (FixedLengthField.class.equals(field.getType())) {
				FixedLengthField fieldValue = (FixedLengthField) FieldUtils.readField(field, this, true);
				
				baos.write(fieldValue.getValue());
			} else if (ArrayUtils.contains(field.getType().getInterfaces(), PacketStructure.class)) {
				PacketStructure fieldValue = (PacketStructure) FieldUtils.readField(field, this, true);
				
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
