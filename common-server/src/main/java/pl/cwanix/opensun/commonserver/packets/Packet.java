package pl.cwanix.opensun.commonserver.packets;

import pl.cwanix.opensun.commonserver.packets.annotations.IncomingPacket;
import pl.cwanix.opensun.commonserver.packets.annotations.OutgoingPacket;
import pl.cwanix.opensun.utils.datatypes.PacketHeader;

import java.io.ByteArrayOutputStream;

public interface Packet extends PacketStructure {

    @Override
    default byte[] toByteArray() throws Exception {
        PacketHeader currentHeader;

        if (this.getClass().isAnnotationPresent(IncomingPacket.class)) {
            currentHeader = new PacketHeader(
                    this.getClass().getAnnotation(IncomingPacket.class).category().getCategory(),
                    this.getClass().getAnnotation(IncomingPacket.class).operation().getCode()
            );
        } else if (this.getClass().isAnnotationPresent(OutgoingPacket.class)) {
            currentHeader = new PacketHeader(
                    this.getClass().getAnnotation(OutgoingPacket.class).category().getCategory(),
                    this.getClass().getAnnotation(OutgoingPacket.class).operation().getCode()
            );
        } else {
            throw new PacketException("Wrong packet definition!");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(currentHeader.getValue());
        writeFieldValuesToStream(baos);

        return baos.toByteArray();
    }
}
