package pl.cwanix.opensun.authserver.server.context;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.authserver.communication.DatabaseProxyConnector;
import pl.cwanix.opensun.authserver.properties.AuthServerProperties;
import pl.cwanix.opensun.authserver.server.session.AuthServerSessionManager;
import pl.cwanix.opensun.commonserver.server.context.SUNServerContext;

@Component
@Getter
@RequiredArgsConstructor
public class AuthServerContext implements SUNServerContext {

	private final DatabaseProxyConnector dbConnector;
	private final AuthServerSessionManager sessionManager;
	private final AuthServerProperties properties;
	
}
