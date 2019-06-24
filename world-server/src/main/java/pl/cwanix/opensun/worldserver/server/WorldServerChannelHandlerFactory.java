package pl.cwanix.opensun.worldserver.server;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;
import pl.cwanix.opensun.worldserver.properties.WorldServerProperties;

@Component
@RequiredArgsConstructor
public class WorldServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final RestTemplate restTemplate;
	//private final WorldServerSessionManager sessionManager;
	private final WorldServerProperties properties;
	
	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new WorldServerChannelHandler(restTemplate, /*sessionManager,*/  properties);
	}
}
