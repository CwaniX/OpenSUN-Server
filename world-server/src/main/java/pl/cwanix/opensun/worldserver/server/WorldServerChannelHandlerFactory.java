package pl.cwanix.opensun.worldserver.server;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class WorldServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final SUNPacketProcessorExecutor packetProcessorExecutor;
	
	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new WorldServerChannelHandler(packetProcessorExecutor);
	}
}
