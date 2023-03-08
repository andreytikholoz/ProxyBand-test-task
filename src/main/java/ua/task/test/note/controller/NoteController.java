package ua.task.test.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.task.test.api.NoteApi;
import ua.task.test.model.NoteDTO;
import ua.task.test.model.NoteListDTO;
import ua.task.test.model.UserDTO;
import ua.task.test.note.service.NoteService;
import ua.task.test.note.service.UserService;

@RestController
public class NoteController implements NoteApi {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<NoteDTO> createNote(NoteDTO noteDTO) {
        String username = getUsername();
        return ResponseEntity.ok(noteService.createNote(noteDTO, username));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CREATED_USER')")
    public ResponseEntity<NoteDTO> updateNote(NoteDTO noteDTO) {
        String username = getUsername();
        return ResponseEntity.ok(noteService.updateNote(noteDTO, username));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CREATED_USER')")
    public ResponseEntity<Void> deleteNote(String id) {
        String username = getUsername();
        noteService.deleteNote(id, username);
        return ResponseEntity.ok().build();
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CREATED_USER')")
    public ResponseEntity<NoteListDTO> getNoteListByUsername(Boolean sort) {
        String username = getUsername();
        return ResponseEntity.ok(noteService.getNoteListByUsername(username, sort));
    }

    @Override
    public ResponseEntity<NoteListDTO> getAllNotes(Boolean sort) {
        return ResponseEntity.ok(noteService.getAllNotes(sort));
    }


    @Override
    @PreAuthorize("hasRole('ROLE_CREATED_USER')")
    public ResponseEntity<NoteDTO> like(String noteId) {
        String username = getUsername();
        return ResponseEntity.ok(noteService.putLike(noteId, username));
    }

    @Override
    @PreAuthorize("hasRole('ROLE_CREATED_USER')")
    public ResponseEntity<NoteDTO> dislike(String noteId) {
        String username = getUsername();
        return ResponseEntity.ok(noteService.putDislike(noteId, username));
    }

    private String getUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}
