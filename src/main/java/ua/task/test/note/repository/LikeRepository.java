package ua.task.test.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ua.task.test.note.entity.LikeEntity;

public interface LikeRepository extends MongoRepository<LikeEntity, String> {
    boolean existsByUsernameAndNoteId(String username, String noteId);

    void deleteByUsernameAndNoteId(String username, String noteId);
}
