package ua.task.test.note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.task.test.model.UserDTO;
import ua.task.test.note.entity.UserEntity;
import ua.task.test.note.mapper.UserMapper;
import ua.task.test.note.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntity = createUserEntity(userDTO);
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return userMapper.map(createdUserEntity);
    }

    public boolean checkUserExistsByUsernameAndPassword(String username, String password) {
        return userRepository.existsByUsernameAndPassword(username, password);
    }

    private UserEntity createUserEntity(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        return userEntity;
    }

}
