package ua.task.test.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.task.test.note.entity.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);
}
