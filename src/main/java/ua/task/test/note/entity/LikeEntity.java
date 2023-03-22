package ua.task.test.note.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Like")
public class LikeEntity {
    private String username;
    private String noteId;
}
