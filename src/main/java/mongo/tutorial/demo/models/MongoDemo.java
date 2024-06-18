package mongo.tutorial.demo.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "mongoDemo")
public class MongoDemo {
    @Id
    private String id;
    private String description;
    private Date createAt;
}
