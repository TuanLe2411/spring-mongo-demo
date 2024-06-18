package mongo.tutorial.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mongo.tutorial.demo.objects.PropertyUpdate;
import mongo.tutorial.demo.services.SystemService;

@RestController
@RequestMapping("/system")
public class SystemController {
    @Autowired
    SystemService systemService;

    @PostMapping("/update-properties")
    public void updateProperties(@RequestBody List<PropertyUpdate> properties) {
        System.out.println(System.getProperty("spring.application.name"));
        // this.systemService.updateProperties(properties);
        System.out.println(System.getProperty("spring.application.name"));
    }
}
