package mongo.tutorial.demo.controllers;

import java.util.List;
import java.util.Map;

import mongo.tutorial.demo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import mongo.tutorial.demo.models.MongoDemo;
import mongo.tutorial.demo.models.Tr069InformLog;
import mongo.tutorial.demo.services.MongoDemoService;

@RestController
@RequestMapping("/mongoDemo")
public class MongoDemoController {
    @Autowired
    MongoDemoService mongoDemoService;

    @PostMapping("/create/{description}")
    public MongoDemo create(@PathVariable("description") String description) {
        return mongoDemoService.create(description);
    }

    @GetMapping("/get-all-before-now")
    public List<Tr069InformLog> getAllBeforeNow() {
        return this.mongoDemoService.getAllBeforeNow();
    }

    @PostMapping("/create-student")
    public Student create(@RequestBody Map<String, String> body) {
        return this.mongoDemoService.createStudent(body);
    }

    @GetMapping("/find-student")
    public Student find(@RequestParam("name") String name) {
        return this.mongoDemoService.findByName(name);
    }

    @GetMapping("/find-all-student")
    public List<Student> findAll(@RequestParam("name") String name) {
        return this.mongoDemoService.findAllByName(name);
    }

    @PostMapping("/update-student")
    public void updateStudent(@RequestParam("id") String id, @RequestParam("name") String name) {
        this.mongoDemoService.updateStudent(id, name);
    }
}
