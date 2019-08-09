package pl.cwanix.opensun.authserver.server;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.server.context.AuthServerContext;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AuthServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {
	
	private final AuthServerContext srv;

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AuthServerChannelHandler(srv);
	}
}
