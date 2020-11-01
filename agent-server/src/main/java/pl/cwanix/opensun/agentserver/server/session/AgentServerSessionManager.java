package pl.cwanix.opensun.agentserver.server.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.domain.UserDTO;
import pl.cwanix.opensun.commonserver.session.SUNSessionManager;

@Slf4j
@Getter
@Setter
@Component
public class AgentServerSessionManager implements SUNSessionManager<UserDTO> {

    private Map<UserDTO, AgentServerSession> sessions;

    public AgentServerSessionManager() {
        sessions = new HashMap<>();
    }

    @Override
    public AgentServerSession startNewSession(final UserDTO user) {
        AgentServerSession newSession = new AgentServerSession(user);
        sessions.put(user, newSession);

        return newSession;
    }

    @Override
    public AgentServerSession getSession(final UserDTO user) {
        return sessions.get(user);
    }

}
