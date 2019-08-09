package pl.cwanix.opensun.agentserver.server.context;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.agentserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.agentserver.properties.AgentServerProperties;
import pl.cwanix.opensun.agentserver.server.session.AgentServerSessionManager;
import pl.cwanix.opensun.commonserver.server.context.SUNServerContext;

@Component
@Getter
@RequiredArgsConstructor
public class AgentServerContext implements SUNServerContext {

	private final DatabaseProxyConnector dbConnector;
	private final AgentServerSessionManager sessionManager;
	private final AgentServerProperties properties;
}
