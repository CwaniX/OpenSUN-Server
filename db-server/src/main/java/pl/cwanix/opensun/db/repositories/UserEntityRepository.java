package pl.cwanix.opensun.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.cwanix.opensun.db.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByName(String name);
}
