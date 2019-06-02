package pl.cwanix.opensun.agentserver.server;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandler;
import pl.cwanix.opensun.commonserver.server.SUNServerChannelHandlerFactory;

@Component
@RequiredArgsConstructor
public class AgentServerChannelHandlerFactory implements SUNServerChannelHandlerFactory {

	private final RestTemplate restTemplate;
	private final AgentServerSessionManager sessionManager;
	private final AgentServerProperties properties;
	
	@Override
	public SUNServerChannelHandler getChannelHandler() {
		return new AgentServerChannelHandler(restTemplate, sessionManager.startNewSession(),  properties);
	}
}
