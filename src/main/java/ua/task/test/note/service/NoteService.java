package ua.task.test.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.task.test.model.NoteDTO;
import ua.task.test.model.NoteListDTO;
import ua.task.test.note.entity.NoteEntity;
import ua.task.test.note.mapper.NoteMapper;
import ua.task.test.note.repository.NoteRepository;

import java.sql.Date;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private NoteMapper noteMapper;

    public NoteDTO createNote(NoteDTO noteDTO, String username) {
        NoteEntity noteEntity = createNoteEntity(noteDTO, username);
        NoteEntity createdNoteEntity = noteRepository.save(noteEntity);
        return noteMapper.map(createdNoteEntity);
    }

    public NoteDTO updateNote(NoteDTO noteDTO, String username) {
        NoteEntity noteEntityToUpdate = noteRepository.findByIdAndUsername(noteDTO.getId(), username).orElseThrow(() ->
                new IllegalStateException("Note with id = [" + noteDTO.getId() + "] not exist"));
        noteEntityToUpdate.setNote(noteDTO.getNote());
        NoteEntity updatedNoteEntity = noteRepository.save(noteEntityToUpdate);
        return noteMapper.map(updatedNoteEntity);
    }

    public void deleteNote(String id, String username) {
        noteRepository.deleteByIdAndUsername(id, username);
    }

    public NoteListDTO getNoteListByUsername(String username, boolean sort) {
        List<NoteEntity> noteEntities = noteRepository.findAllByUsername(username);
        if (sort) {
            noteEntities.sort(Collections.reverseOrder());
        }
        List<NoteDTO> notes = noteEntities
                .stream()
                .map(noteMapper::map)
                .collect(Collectors.toList());
        NoteListDTO noteListDTO = new NoteListDTO();
        noteListDTO.setNotes(notes);
        return noteListDTO;
    }

    public NoteListDTO getAllNotes(boolean sort) {
        List<NoteEntity> noteEntities = noteRepository.findAll();
        if (sort) {
            noteEntities.sort(Collections.reverseOrder());
        }
        List<NoteDTO> notes = noteEntities
                .stream()
                .map(noteMapper::map)
                .collect(Collectors.toList());
        NoteListDTO noteListDTO = new NoteListDTO();
        noteListDTO.setNotes(notes);
        return noteListDTO;
    }

    public NoteDTO putLike(String noteId, String username) {
        NoteEntity noteEntityToLike = noteRepository.findById(noteId).orElseThrow(() ->
                new IllegalStateException("Note with id = [" + noteId + "] not exist"));
        noteEntityToLike.setLikes(noteEntityToLike.getLikes() + 1);
        NoteEntity likedNoteEntity = noteRepository.save(noteEntityToLike);
        return noteMapper.map(likedNoteEntity);
    }

    public NoteDTO putDislike(String noteId, String username) {
        NoteEntity noteEntityToDislike = noteRepository.findById(noteId).orElseThrow(() ->
                new IllegalStateException("Note with id = [" + noteId + "] not exist"));
        noteEntityToDislike.setLikes(noteEntityToDislike.getLikes() - 1);
        NoteEntity dislikedNoteEntity = noteRepository.save(noteEntityToDislike);
        return noteMapper.map(dislikedNoteEntity);
    }

    private NoteEntity createNoteEntity(NoteDTO noteDTO, String username) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setUsername(username);
        noteEntity.setNote(noteDTO.getNote());
        noteEntity.setLikes(noteDTO.getLikes());
        noteEntity.setDate(Date.from(Instant.now()));
        return noteEntity;
    }
}
