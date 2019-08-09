package pl.cwanix.opensun.authserver.packet.s2c;

import org.apache.commons.lang3.ArrayUtils;

import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.commonserver.packets.OutgoingPacket;
import pl.cwanix.opensun.commonserver.packets.Packet;
import pl.cwanix.opensun.commonserver.packets.PacketCategory;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@OutgoingPacket(category = PacketCategory.AUTH, type = 0x02)
public class S2CAnsVerifyPacket implements Packet<AuthServerContext> {
	
	private FixedLengthField result;
	
	public S2CAnsVerifyPacket() {
		this.result = new FixedLengthField(1, (byte) 0x00);
	}
	
	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(result);
	}
}
