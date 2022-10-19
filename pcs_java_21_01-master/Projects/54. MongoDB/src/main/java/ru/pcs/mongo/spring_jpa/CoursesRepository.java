package ru.pcs.mongo.spring_jpa;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CoursesRepository extends MongoRepository<Course, String> {
    @Query(value = "{active: false, $or: [{keywords: ?keywords}, {studentsCount: {$lt: ?1}}]}")
    List<Course> find(@Param("keywords") List<String> keywords, @Param("studentCount") int maxStudentsCount);

    List<Course> findAllByActiveIsTrueAndKeywordsContainsAndStudentsCountBefore(String keyword, int studentsCount);
}
