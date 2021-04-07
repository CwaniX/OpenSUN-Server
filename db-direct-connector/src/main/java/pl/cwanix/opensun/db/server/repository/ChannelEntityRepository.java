package pl.cwanix.opensun.db.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cwanix.opensun.db.server.entity.ChannelEntity;

public interface ChannelEntityRepository extends JpaRepository<ChannelEntity, Integer> {
}
