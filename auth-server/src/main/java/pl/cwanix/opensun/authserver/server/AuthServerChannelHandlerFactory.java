package pl.cwanix.opensun.authserver.server;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.authserver.server.session.AuthServerSessionManager;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AuthServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {
	
	private final RestTemplate restTemplate;
	private final AuthServerSessionManager sessionManager;
	private final AuthServerProperties properties;

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AuthServerChannelHandler(restTemplate, sessionManager, properties);
	}
}
