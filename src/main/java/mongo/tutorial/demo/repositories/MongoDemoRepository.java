package mongo.tutorial.demo.repositories;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.tutorial.demo.models.MongoDemo;
import java.util.List;
import java.util.Date;


public interface MongoDemoRepository extends MongoRepository<MongoDemo, String>{
    @Aggregation("{ $match: { createAt: { $lte: ?0 } } }")
    List<MongoDemo> findByCreateAtMin(Date createAt);
}