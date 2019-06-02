package pl.cwanix.opensun.agentserver.server.session;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.session.SUNSessionManager;

@Slf4j
@Getter
@Setter
@Component
public class AgentServerSessionManager implements SUNSessionManager {
	
	private List<AgentServerSession> sessions;
	
	public AgentServerSessionManager() {
		sessions = new ArrayList<>();
	}

	@Override
	public AgentServerSession startNewSession() {
		AgentServerSession newSession = new AgentServerSession();
		sessions.add(newSession);
		
		return newSession;
	}

}
