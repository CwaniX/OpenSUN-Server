package pl.cwanix.opensun.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServerDTO {

    private int id;
    private int port;
    private String ip;
    private String name;
}
