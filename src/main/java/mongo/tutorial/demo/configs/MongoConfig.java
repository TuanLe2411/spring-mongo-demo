//package mongo.tutorial.demo.configs;
//
//import java.util.Collection;
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.MongoClientSettings;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//
//@Configuration
//public class MongoConfig extends AbstractMongoClientConfiguration {
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;
//
//    @Value("${spring.data.mongodb.host}")
//    private String host;
//
//    @Value("${spring.data.mongodb.port}")
//    private int port;
//
//    @SuppressWarnings("null")
//    @Override
//    public MongoClient mongoClient() {
//        ConnectionString connectionString = new ConnectionString(getConnectionString());
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @SuppressWarnings("null")
//    @Override
//    protected String getDatabaseName() {
//        return databaseName;
//    }
//
//    @SuppressWarnings("null")
//    @Override
//    public Collection<String> getMappingBasePackages() {
//        return Collections.singleton("mongo.tutorial.demo.models");
//    }
//
//    private String getConnectionString() {
//        return "mongodb://" + host + ":" + port + "/" + databaseName;
//    }
//}
