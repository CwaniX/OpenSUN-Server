package pl.cwanix.opensun.authserver.server.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.commonserver.session.SUNSessionManager;
import pl.cwanix.opensun.domain.UserDTO;

@Slf4j
@Getter
@Setter
@Component
public class AuthServerSessionManager implements SUNSessionManager<UserDTO> {

    private Map<UserDTO, AuthServerSession> sessions;

    public AuthServerSessionManager() {
        sessions = new HashMap<>();
    }

    @Override
    public AuthServerSession startNewSession(final UserDTO user) {
        AuthServerSession newSession = new AuthServerSession();
        sessions.put(user, newSession);

        return newSession;
    }

    @Override
    public AuthServerSession getSession(final UserDTO user) {
        // TODO Auto-generated method stub
        return null;
    }
}
