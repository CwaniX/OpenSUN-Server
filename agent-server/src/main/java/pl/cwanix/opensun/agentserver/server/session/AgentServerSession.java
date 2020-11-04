package pl.cwanix.opensun.agentserver.server.session;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.cwanix.opensun.model.character.CharacterModel;
import pl.cwanix.opensun.model.account.UserModel;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
@RequiredArgsConstructor
public class AgentServerSession implements SUNSession {

    private final UserModel user;

    private CharacterModel character;

    public boolean isAuthenticated() {
        return user != null;
    }
}
