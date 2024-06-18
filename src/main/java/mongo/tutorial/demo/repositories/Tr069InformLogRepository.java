package mongo.tutorial.demo.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import mongo.tutorial.demo.models.Tr069InformLog;

public interface Tr069InformLogRepository extends MongoRepository<Tr069InformLog, String> {
    @Aggregation(pipeline = {
        "{$match:{createTime:{$lte:ISODate('?0')}}}"
    })
    List<Tr069InformLog> findByCreateTime(String createTime);
}
