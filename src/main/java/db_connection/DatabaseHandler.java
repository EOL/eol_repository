package db_connection;

import com.mongodb.MongoClient;
import com.mongodb.client.ClientSession;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.TransactionBody;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.client.model.Indexes;
import org.bson.Document;

public class DatabaseHandler {

    public DatabaseHandler()
    {

    }

    public boolean dbSetup()
    {
        final MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
        final ClientSession clientSession = mongoClient.startSession();



        TransactionBody txnBody = new TransactionBody<String>() {
            public String execute() {
                MongoCollection<Document> references = mongoClient.getDatabase("eol").getCollection("references");
                MongoCollection<Document> nodes = mongoClient.getDatabase("eol").getCollection("nodes");
                MongoCollection<Document> media = mongoClient.getDatabase("eol").getCollection("media");
                MongoCollection<Document> articles = mongoClient.getDatabase("eol").getCollection("articles");
                MongoCollection<Document> traits = mongoClient.getDatabase("eol").getCollection("traits");
                MongoCollection<Document> metadata = mongoClient.getDatabase("eol").getCollection("metadata");

                // create indices

                // references
                references.createIndex(Indexes.descending("modifiedAt"));
                references.createIndex(Indexes.ascending("resourceId"));

                // nodes
                nodes.createIndex(Indexes.descending("modifiedAt"));
                nodes.createIndex(Indexes.ascending("resourceId"));
                nodes.createIndex(Indexes.ascending("parentGnId"));
                nodes.createIndex(Indexes.ascending("parentId"));
                nodes.createIndex(Indexes.ascending("pageId"));
                nodes.createIndex(Indexes.ascending("acceptedNameUsageId"));
                nodes.createIndex(Indexes.ascending("rank"));
                nodes.createIndex(Indexes.ascending("generatedNodeId"), new IndexOptions().unique(true));

                // media
                media.createIndex(Indexes.descending("modifiedAt"));
                media.createIndex(Indexes.ascending("resourceId"));
                media.createIndex(Indexes.ascending("nodeId", "resourceId"));

                // articles
                articles.createIndex(Indexes.descending("modifiedAt"));
                articles.createIndex(Indexes.ascending("resourceId"));
                articles.createIndex(Indexes.ascending("nodeId", "resourceId"));

                // traits
                traits.createIndex(Indexes.descending("modifiedAt"));
                traits.createIndex(Indexes.ascending("resourceId"));
                traits.createIndex(Indexes.ascending("nodeId", "resourceId"));

                // metadata
                metadata.createIndex(Indexes.descending("modifiedAt"));
                metadata.createIndex(Indexes.ascending("resourceId"));
                metadata.createIndex(Indexes.ascending("traitId"));

                return "Inserted into collections in different databases";

            }
        };
        try {
    /*
       Step 4: Use .withTransaction() to start a transaction,
       execute the callback, and commit (or abort on error).
    */
            clientSession.withTransaction(txnBody);
            return true;
        } catch (RuntimeException e) {
            // some error handling
            return false;
        } finally {
            clientSession.close();
        }

    }

}
