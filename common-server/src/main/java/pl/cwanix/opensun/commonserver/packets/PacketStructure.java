package pl.cwanix.opensun.commonserver.packets;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.utils.datatypes.SUNDataType;

public interface PacketStructure extends SUNDataType {

	public default byte[] toByteArray() throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		writeFeldValuesToStream(baos);
		
		return baos.toByteArray();
	}
	
	@SuppressWarnings("unchecked")
	public default void writeFeldValuesToStream(OutputStream os) throws Exception {
		for (Object object : getOrderedFields()) {
			if (ArrayUtils.contains(object.getClass().getInterfaces(), SUNDataType.class)) {
				SUNDataType fieldValue = (SUNDataType) object;
				
				os.write(fieldValue.toByteArray());
			} else if (ArrayUtils.contains(object.getClass().getInterfaces(), List.class)) {
				List<PacketStructure> fieldValue = (List<PacketStructure>) object;
				
				for (PacketStructure value : fieldValue) {
					os.write(value.toByteArray());
				}
			}
		}
	}
}
