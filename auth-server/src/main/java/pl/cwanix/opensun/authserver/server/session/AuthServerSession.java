package pl.cwanix.opensun.authserver.server.session;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;
import pl.cwanix.opensun.authserver.entities.UserEntity;
import pl.cwanix.opensun.commonserver.session.SUNSession;

@Getter
@Setter
public class AuthServerSession implements SUNSession {
	
	private UserEntity user;
	private byte[] encKey;
	
	public AuthServerSession() {
		encKey = new byte[4];
		
		Random random = new Random();
		random.nextBytes(getEncKey());
	}
	
	public boolean isAuthenticated() {
		return user != null;
	}

}
