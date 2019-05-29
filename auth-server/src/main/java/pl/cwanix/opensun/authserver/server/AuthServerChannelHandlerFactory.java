package pl.cwanix.opensun.authserver.server;

import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

public class AuthServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AuthServerChannelHandler();
	}

}
