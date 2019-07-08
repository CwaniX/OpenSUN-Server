package pl.cwanix.opensun.utils.datatypes;

public interface SUNDataType {

	public byte[] toByteArray() throws Exception;
	
	public default Object[] getOrderedFields() {
		return new Object[0];
	}
}
