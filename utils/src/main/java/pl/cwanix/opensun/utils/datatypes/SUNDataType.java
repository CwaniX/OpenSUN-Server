package pl.cwanix.opensun.utils.datatypes;

public interface SUNDataType {

    byte[] toByteArray() throws Exception;

    default Object[] getOrderedFields() {
        return new Object[0];
    }
}
