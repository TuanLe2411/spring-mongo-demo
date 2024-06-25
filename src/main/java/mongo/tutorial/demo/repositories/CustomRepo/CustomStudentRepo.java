package mongo.tutorial.demo.repositories.CustomRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import mongo.tutorial.demo.models.Student;

@Repository
public class CustomStudentRepo {
    @Autowired
    private MongoTemplate mongoTemplate;

    public void upsertStudent(Student s) {
        Query query = new Query(Criteria.where("studentId").is(s.getStudentId()));
        Update update = new Update();
        update.set("name", s.getName());
        update.set("age", s.getAge());
        update.set("studentId", s.getStudentId());
        mongoTemplate.upsert(query, update, Student.class);
    }
}
