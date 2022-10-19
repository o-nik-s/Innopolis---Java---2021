package ru.pcs.mongo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoConfig.class);
        MongoTemplate mongoTemplate = context.getBean(MongoTemplate.class);
//        Teacher teacher = Teacher.builder()
//                .firstName("Преподаватель")
//                .lastName("Преподавателев")
//                .build();
//        mongoTemplate.save(teacher, "teachers");

        List<Course> courses = mongoTemplate.find(Query.query(
                where("active").is(true).
                        orOperator(
                                where("keywords").is("java core"),
                                where("studentsCount").lt(35))),Course.class, "courses");
        System.out.println(courses);
    }
}
