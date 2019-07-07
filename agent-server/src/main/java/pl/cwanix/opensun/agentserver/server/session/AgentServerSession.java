package pl.cwanix.opensun.agentserver.server.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.cwanix.opensun.agentserver.entities.CharacterEntity;
import pl.cwanix.opensun.agentserver.entities.UserEntity;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
@RequiredArgsConstructor
public class AgentServerSession implements SUNSession {
	
	private final UserEntity user;
	
	private CharacterEntity character;
	
	public boolean isAuthenticated() {
		return user != null;
	}
}
