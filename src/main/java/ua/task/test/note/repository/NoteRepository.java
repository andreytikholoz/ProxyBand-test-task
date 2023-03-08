package ua.task.test.note.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.task.test.note.entity.NoteEntity;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<NoteEntity, String> {
    void deleteByIdAndUsername(String id, String username);

    List<NoteEntity> findAllByUsername(String username);

    List<NoteEntity> findAllByUsernameOrderByDate(String username);

    List<NoteEntity> findAllOrderByDate();
}
