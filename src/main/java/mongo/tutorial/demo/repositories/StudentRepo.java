package mongo.tutorial.demo.repositories;

import mongo.tutorial.demo.models.Student;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import java.util.List;

public interface StudentRepo extends MongoRepository<Student, String> {

    @Aggregation(pipeline = {
        "{$match:{name: ?0}}",
        "{$limit: 1}"
    })
    Student findOneWithConditions(String name);

    @Query("{'name':  ?0}")
    List<Student> findWithConditions(String name);

    @Query("{'studentId' : ?0}")
    @Update("{'$set': {'name': ?1}}")
    void updateName(String id, String name);
}
