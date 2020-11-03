package pl.cwanix.opensun.model.server;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerModel {

    private int id;
    private int port;
    private String ip;
    private String name;
}
