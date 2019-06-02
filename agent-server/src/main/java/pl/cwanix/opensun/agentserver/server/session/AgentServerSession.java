package pl.cwanix.opensun.agentserver.server.session;

import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.commonserver.session.SUNSession;

public class AgentServerSession implements SUNSession {
	
	private UserEntity user;
	
	public boolean isAuthenticated() {
		return user != null;
	}
}
