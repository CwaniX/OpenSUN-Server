package pl.cwanix.opensun.authserver.server.session;

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
public class AuthServerSessionManager implements SUNSessionManager {

	private List<AuthServerSession> sessions;
	
	public AuthServerSessionManager() {
		sessions = new ArrayList<>();
	}
	
	@Override
	public AuthServerSession startNewSession() {
		AuthServerSession newSession = new AuthServerSession();
		sessions.add(newSession);
		
		return newSession;
	}
}
