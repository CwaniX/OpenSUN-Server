package pl.cwanix.opensun.commonserver.session;

public interface SUNSessionManager<T> {

    SUNSession startNewSession(T object);
    SUNSession getSession(T object);
}
