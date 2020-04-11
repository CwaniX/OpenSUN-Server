package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.ClassUtils;

import pl.cwanix.opensun.utils.datatypes.SUNDataType;

public interface PacketStructure extends SUNDataType {

	public default byte[] toByteArray() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeFieldValuesToStream(baos);
		
		return baos.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public default void writeFieldValuesToStream(OutputStream os) throws Exception {
		for (Object object : getOrderedFields()) {
			List<Class<?>> interfaces = ClassUtils.getAllInterfaces(object.getClass());
			
			if (interfaces.contains(SUNDataType.class)) {
				SUNDataType fieldValue = (SUNDataType) object;
				
				os.write(fieldValue.toByteArray());
			} else if (interfaces.contains(List.class)) {
				List<PacketStructure> fieldValue = (List<PacketStructure>) object;
				
				for (PacketStructure value : fieldValue) {
					os.write(value.toByteArray());
				}
			}
		}
	}
}
