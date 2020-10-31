package pl.cwanix.opensun.authserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerEntity {

    private int id;
    private int port;
    private String ip;
    private String name;
}
