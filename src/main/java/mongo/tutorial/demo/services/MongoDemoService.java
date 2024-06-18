package mongo.tutorial.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Map;

import mongo.tutorial.demo.models.Student;
import mongo.tutorial.demo.repositories.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mongo.tutorial.demo.models.MongoDemo;
import mongo.tutorial.demo.models.Tr069InformLog;
import mongo.tutorial.demo.repositories.MongoDemoRepository;
import mongo.tutorial.demo.repositories.Tr069InformLogRepository;

@Service
public class MongoDemoService {
    @Autowired
    MongoDemoRepository mongoDemoRepository;
    @Autowired
    Tr069InformLogRepository tr069InformLogRepository;
    @Autowired
    StudentRepo studentRepo;

    public MongoDemo create(String description) {
        MongoDemo mongoDemo = new MongoDemo();
        mongoDemo.setDescription(description);
        mongoDemo.setCreateAt(new Date());
        return mongoDemoRepository.save(mongoDemo);
    }

    public List<Tr069InformLog> getAllBeforeNow() {
        return tr069InformLogRepository.findByCreateTime("2024-10-04T16:07:49.750Z");
    }

    public Student createStudent(Map<String, String> payload) {
        Student s = new Student();
        s.setStudentId(payload.get("studentId"));
        s.setAge(payload.get("age"));
        s.setName(payload.get("name"));
        return this.studentRepo.save(s);
    }

    public Student findByName(String name) {
        return this.studentRepo.findOneWithConditions(name);
    }

    public List<Student> findAllByName(String name) {
        return this.studentRepo.findWithConditions(name);
    }

    public void updateStudent(String id, String name) {
        this.studentRepo.updateName(id, name);
    }
}
