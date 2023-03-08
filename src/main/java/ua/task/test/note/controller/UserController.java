package ua.task.test.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ua.task.test.api.UserApi;
import ua.task.test.model.UserDTO;
import ua.task.test.note.service.UserService;

@RestController
public class UserController implements UserApi {

    @Autowired
    private UserService userService;

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
}
