package pl.cwanix.opensun.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cwanix.opensun.db.entities.ChannelEntity;

public interface ChannelEntityRepository extends JpaRepository<ChannelEntity, Integer> {
}
