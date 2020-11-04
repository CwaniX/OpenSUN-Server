package pl.cwanix.opensun.model.server;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChannelModel {

    private int id;
    private ServerModel server;
    private String name;
}
