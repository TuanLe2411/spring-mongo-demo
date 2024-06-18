package mongo.tutorial.demo.models;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document(collection = "tr069_inform_log")
@Data
public class Tr069InformLog {
    @Id
    private String id;
    private String keyValue;
    private String productName;
    private Date createTime;
}