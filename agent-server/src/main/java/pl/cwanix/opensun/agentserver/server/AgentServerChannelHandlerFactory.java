package pl.cwanix.opensun.agentserver.server;

import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

public class AgentServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AgentServerChannelHandler();
	}
}
