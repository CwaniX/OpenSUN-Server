package pl.cwanix.opensun.authserver.server.session;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.session.SUNSession;
import pl.cwanix.opensun.model.account.UserModel;

@Getter
@Setter
public class AuthServerSession implements SUNSession {

    private UserModel user;
    private byte[] encKey;

    public AuthServerSession() {
        //encKey = new byte[4];

        encKey = new byte[] {0, 0, 0, 0};

        //Random random = new Random();
        //random.nextBytes(getEncKey());
    }

    public boolean isAuthenticated() {
        return user != null;
    }
}
