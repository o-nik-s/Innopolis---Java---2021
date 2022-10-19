package ru.pcs.mongo.driver;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;

import java.util.Arrays;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.*;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase database = mongoClient.getDatabase("education");
        MongoCollection<Document> collection = database.getCollection("courses");

//        collection.find().forEach(document -> System.out.println(document.getBoolean("active")));

//        db.courses.find({active: true, $or: [{studentsCount: {$lt: 35}}, {keywords: 'java core'}]});

        Document query = new Document();
        query
                .append("active", true)
                .append("$or", Arrays.asList(new Document("keywords", "java core"),
                        new Document("studentsCount", new Document("$lt", 35))));

        FindIterable<Document> documents = collection.find(query)
                .projection(new Document("hours", 1).append("active", 1).append("_id", 0));

        FindIterable<Document> byAnotherQuery = collection.find(
                and(
                        new Document("active", true),
                        or(
                                new Document("keywords", "java core"),
                                lt("studentsCount", 35)))
        ).projection(fields(include("studentsCount", "hours", "active"), excludeId()));

        for (Document document : byAnotherQuery) {
            System.out.println(document.toJson());
        }
    }
}
