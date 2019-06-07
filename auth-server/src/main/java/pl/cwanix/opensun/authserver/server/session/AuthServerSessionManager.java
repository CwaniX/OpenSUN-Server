package pl.cwanix.opensun.authserver.server.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.authserver.entities.UserEntity;
import pl.cwanix.opensun.commonserver.session.SUNSessionManager;

@Slf4j
@Getter
@Setter
@Component
public class AuthServerSessionManager implements SUNSessionManager<UserEntity> {

	private Map<UserEntity, AuthServerSession> sessions;
	
	public AuthServerSessionManager() {
		sessions = new HashMap<>();
	}
	
	@Override
	public AuthServerSession startNewSession(UserEntity user) {
		AuthServerSession newSession = new AuthServerSession();
		sessions.put(user, newSession);
		
		return newSession;
	}

	@Override
	public AuthServerSession getSession(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}
}
