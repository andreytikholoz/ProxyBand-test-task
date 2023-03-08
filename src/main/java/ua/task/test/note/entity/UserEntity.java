package ua.task.test.note.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "User")
public class UserEntity {
    @Id
    private String id;
    private String username;
    private String password;
}

