package pl.cwanix.opensun.commonserver.session;

public interface SUNSessionManager<T> {

	public SUNSession startNewSession(T object);
	public SUNSession getSession(T object);
}
