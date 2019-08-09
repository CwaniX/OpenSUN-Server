package pl.cwanix.opensun.worldserver.server;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;
import pl.cwanix.opensun.worldserver.server.context.WorldServerContext;

@Component
@RequiredArgsConstructor
public class WorldServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final WorldServerContext srv;
	
	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new WorldServerChannelHandler(srv);
	}
}
