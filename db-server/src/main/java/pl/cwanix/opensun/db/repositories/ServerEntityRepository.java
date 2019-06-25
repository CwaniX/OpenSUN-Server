package pl.cwanix.opensun.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cwanix.opensun.db.entities.ServerEntity;

public interface ServerEntityRepository extends JpaRepository<ServerEntity, Integer> {

}
