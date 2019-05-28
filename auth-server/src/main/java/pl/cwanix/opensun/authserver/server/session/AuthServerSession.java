package pl.cwanix.opensun.authserver.server.session;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
public class AuthServerSession implements SUNSession {
	
	private byte[] encKey = { 0, 0, 0, 0 };

}
