package pl.cwanix.opensun.model.server;

import java.util.List;

public interface ServerDataSource {

    List<ServerModel> findServers();
    List<ChannelModel> findChannels();
    ServerModel findServer(int id);
}
