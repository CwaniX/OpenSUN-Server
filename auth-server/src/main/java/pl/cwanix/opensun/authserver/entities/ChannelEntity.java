package pl.cwanix.opensun.authserver.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelEntity {

    private int id;
    private ServerEntity server;
    private String name;
}
