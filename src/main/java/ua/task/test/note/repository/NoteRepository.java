package ua.task.test.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.task.test.note.entity.NoteEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends MongoRepository<NoteEntity, String> {
    void deleteByIdAndUsername(String id, String username);

    List<NoteEntity> findAllByUsername(String username);

    List<NoteEntity> findAll();

    Optional<NoteEntity> findByIdAndUsername(String id, String username);
}
