import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class MongoRunner {
    public boolean run() throws UnknownHostException {
        MongoTemplate template = createMongoTemplateFor("", "allocation", "allocation", "showcase_inseasoncatalog", 1000);
        return template.collectionExists("inSeasonCustomerChoice");
    }

    private MongoTemplate createMongoTemplateFor(String host, String user, String password, String databaseName,
                                                 int timeout) throws UnknownHostException {
        List<ServerAddress> seeds = new ArrayList<>();
        seeds.add(new ServerAddress(host));
        List<MongoCredential> credentials = new ArrayList<>();
        credentials.add(
                MongoCredential.createCredential(
                        user,
                        databaseName,
                        password.toCharArray()
                )
        );
        MongoClientOptions mongoClientOptions = MongoClientOptions.builder()
                .connectTimeout(timeout).build();
        MongoClient mongoClient = new MongoClient(seeds, credentials, mongoClientOptions);
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongoClient, databaseName);

        return new MongoTemplate(mongoDbFactory);
    }

}
