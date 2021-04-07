package pl.cwanix.opensun.db.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.cwanix.opensun.db.server.entity.ServerEntity;

public interface ServerEntityRepository extends JpaRepository<ServerEntity, Integer> {

}
