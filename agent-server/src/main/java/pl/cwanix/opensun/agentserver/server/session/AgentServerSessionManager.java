package pl.cwanix.opensun.agentserver.server.session;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import pl.cwanix.opensun.model.account.UserModel;
import pl.cwanix.opensun.commonserver.session.SUNSessionManager;

@Slf4j
@Getter
@Setter
@Component
public class AgentServerSessionManager implements SUNSessionManager<UserModel> {

    private Map<UserModel, AgentServerSession> sessions;

    public AgentServerSessionManager() {
        sessions = new HashMap<>();
    }

    @Override
    public AgentServerSession startNewSession(final UserModel user) {
        AgentServerSession newSession = new AgentServerSession(user);
        sessions.put(user, newSession);

        return newSession;
    }

    @Override
    public AgentServerSession getSession(final UserModel user) {
        return sessions.get(user);
    }

}
