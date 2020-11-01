package pl.cwanix.opensun.db.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import pl.cwanix.opensun.db.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByName(String name);

    @Transactional
    @Procedure(procedureName = "func_create_user_and_account")
    Integer create(String name, String password);
}
