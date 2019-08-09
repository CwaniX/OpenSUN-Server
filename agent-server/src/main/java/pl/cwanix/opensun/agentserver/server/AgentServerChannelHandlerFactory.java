package pl.cwanix.opensun.agentserver.server;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.server.context.AgentServerContext;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AgentServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final AgentServerContext srv;
	
	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AgentServerChannelHandler(srv);
	}
}
