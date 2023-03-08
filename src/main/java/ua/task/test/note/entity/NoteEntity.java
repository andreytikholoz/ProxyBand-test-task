package ua.task.test.note.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Note")
public class NoteEntity {
    @Id
    private String id;
    private String username;
    private String note;
    private int likes;
    private Date date;
}
