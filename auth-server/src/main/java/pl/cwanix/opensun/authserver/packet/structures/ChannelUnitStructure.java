package pl.cwanix.opensun.authserver.packet.structures;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;
import pl.cwanix.opensun.authserver.entities.ChannelEntity;
import pl.cwanix.opensun.commonserver.packets.PacketStructure;
import pl.cwanix.opensun.utils.datatypes.FixedLengthField;

@Getter
public class ChannelUnitStructure implements PacketStructure {

	private FixedLengthField channelName;
	private FixedLengthField unknown1;
	private FixedLengthField channelId;
	private FixedLengthField serverId;
	private FixedLengthField unknown2;
	private FixedLengthField unknown3;

	public ChannelUnitStructure(ChannelEntity channel) {
		this.channelName = new FixedLengthField(32, channel.getName());
		this.unknown1 = new FixedLengthField(1);
		this.serverId = new FixedLengthField(1, channel.getServer().getId());
		this.channelId = new FixedLengthField(1, channel.getId());
		this.unknown2 = new FixedLengthField(1, 0x01);
		this.unknown3 = new FixedLengthField(1);
	}

	@Override
	public Object[] getOrderedFields() {
		return ArrayUtils.toArray(channelName, unknown1, serverId, channelId, unknown2, unknown3);
	}
}
