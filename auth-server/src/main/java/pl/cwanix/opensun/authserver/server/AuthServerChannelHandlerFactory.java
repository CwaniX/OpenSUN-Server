package pl.cwanix.opensun.authserver.server;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.server.session.AuthServerSessionManager;
import pl.cwanix.opensun.commonserver.packets.SUNPacketProcessorExecutor;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AuthServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final SUNPacketProcessorExecutor packetProcessorExecutor;
	private final AuthServerSessionManager sessionManager;

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AuthServerChannelHandler(packetProcessorExecutor, sessionManager);
	}
}
