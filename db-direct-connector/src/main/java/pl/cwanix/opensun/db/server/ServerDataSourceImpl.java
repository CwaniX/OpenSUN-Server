package pl.cwanix.opensun.db.server;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pl.cwanix.opensun.db.server.entity.ChannelEntity;
import pl.cwanix.opensun.db.server.entity.ServerEntity;
import pl.cwanix.opensun.db.server.repository.ChannelEntityRepository;
import pl.cwanix.opensun.db.server.repository.ServerEntityRepository;
import pl.cwanix.opensun.model.server.ChannelModel;
import pl.cwanix.opensun.model.server.ServerDataSource;
import pl.cwanix.opensun.model.server.ServerModel;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ServerDataSourceImpl implements ServerDataSource {

    private final ServerEntityRepository serverEntityRepository;
    private final ChannelEntityRepository channelEntityRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ServerModel> findServers() {
        final List<ServerEntity> entities = serverEntityRepository.findAll();

        return entities.stream()
                .map(entity -> modelMapper.map(entity, ServerModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ChannelModel> findChannels() {
        final List<ChannelEntity> entities = channelEntityRepository.findAll();

        return entities.stream()
                .map(entity -> modelMapper.map(entity, ChannelModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public ServerModel findServer(final int id) {
        final ServerEntity entity = serverEntityRepository.findById(id).orElseThrow(() -> new RuntimeException("wrong server")); //TODO

        return modelMapper.map(entity, ServerModel.class);
    }
}
