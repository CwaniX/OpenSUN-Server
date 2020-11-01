package pl.cwanix.opensun.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelDTO {

    private int id;
    private ServerDTO server;
    private String name;
}
