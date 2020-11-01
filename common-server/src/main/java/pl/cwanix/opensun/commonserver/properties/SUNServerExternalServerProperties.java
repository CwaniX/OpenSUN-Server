package pl.cwanix.opensun.commonserver.properties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SUNServerExternalServerProperties {

    private String ip;
    private int port;

    public String getServerUrl() {
        return "http://" + ip + ":" + port;
    }
}
