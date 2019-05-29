package pl.cwanix.opensun.agentserver.server;

import org.springframework.stereotype.Component;

import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
public class AgentServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AgentServerChannelHandler();
	}
}
