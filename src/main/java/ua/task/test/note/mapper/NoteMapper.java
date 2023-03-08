package ua.task.test.note.mapper;

import org.springframework.stereotype.Component;
import ua.task.test.model.NoteDTO;
import ua.task.test.note.entity.NoteEntity;

@Component
public class NoteMapper {
    public NoteDTO map(NoteEntity noteEntity) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setId(noteEntity.getId());
        noteDTO.setNote(noteEntity.getNote());
        noteDTO.setLikes(noteEntity.getLikes());
        return noteDTO;
    }
}
