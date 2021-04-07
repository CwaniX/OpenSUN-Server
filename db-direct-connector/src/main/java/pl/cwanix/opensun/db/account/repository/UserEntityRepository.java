package pl.cwanix.opensun.db.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import pl.cwanix.opensun.db.account.entity.UserEntity;

import javax.transaction.Transactional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {

    UserEntity findByName(String name);

    @Transactional
    @Procedure(procedureName = "func_create_user_and_account")
    Integer create(String name, String password);
}
