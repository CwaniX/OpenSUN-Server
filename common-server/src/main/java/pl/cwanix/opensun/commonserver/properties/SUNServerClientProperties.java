package pl.cwanix.opensun.commonserver.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@SuppressWarnings("checkstyle:MagicNumber")
public class SUNServerClientProperties {

    private int port;
    private int maxQueueSize = 128;
    private int maxThreadCount = 2;
    private boolean epollMode = false;
}
