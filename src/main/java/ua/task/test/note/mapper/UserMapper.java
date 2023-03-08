package ua.task.test.note.mapper;

import org.springframework.stereotype.Component;
import ua.task.test.model.UserDTO;
import ua.task.test.note.entity.UserEntity;

@Component
public class UserMapper {
    public UserDTO map(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userEntity.getId());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setUsername(userEntity.getUsername());
        return userDTO;
    }
}
