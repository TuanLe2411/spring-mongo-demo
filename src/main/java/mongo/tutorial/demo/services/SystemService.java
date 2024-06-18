package mongo.tutorial.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mongo.tutorial.demo.objects.PropertyUpdate;

@Service
public class SystemService {
    public void updateProperties(List<PropertyUpdate> properties) {
        properties.forEach(property -> {
            System.setProperty(property.getKey(), property.getValue());
        });
    }
}
