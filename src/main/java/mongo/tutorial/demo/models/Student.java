package mongo.tutorial.demo.models;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;
import com.querydsl.core.annotations.QueryEntity;

@Document(collection = "students")
@CompoundIndexes({
    @CompoundIndex(name = "age_index", def = "{'age': 1}"),
    @CompoundIndex(name = "name_index", def = "{'name': 1}"),
    @CompoundIndex(name = "main_index", def = "{'studentId': 1}", unique = true)
})
@QueryEntity
@Data
@ToString
public class Student {
    @Id
    private String id;
    private String studentId;
    private String name;
    private String age;
}
