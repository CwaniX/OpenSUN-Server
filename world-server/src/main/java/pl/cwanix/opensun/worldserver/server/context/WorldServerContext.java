package pl.cwanix.opensun.worldserver.server.context;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.cwanix.opensun.commonserver.server.context.SUNServerContext;
import pl.cwanix.opensun.worldserver.communication.DatabaseProxyConnector;

@Component
@Getter
@RequiredArgsConstructor
public class WorldServerContext implements SUNServerContext {

	private final DatabaseProxyConnector dbConnector;
}
