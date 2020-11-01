package pl.cwanix.opensun.agentserver.server.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.cwanix.opensun.domain.CharacterDTO;
import pl.cwanix.opensun.domain.UserDTO;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
@RequiredArgsConstructor
public class AgentServerSession implements SUNSession {

    private final UserDTO user;

    private CharacterDTO character;

    public boolean isAuthenticated() {
        return user != null;
    }
}
