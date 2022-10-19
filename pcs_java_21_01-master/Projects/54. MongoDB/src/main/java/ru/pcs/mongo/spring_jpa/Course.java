package ru.pcs.mongo.spring_jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Map;

/**
 * 24.11.2021
 * 54. MongoDB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "courses")
public class Course {
    @Id
    private String _id;
    private Integer studentsCount;
    private Integer hours;
    private List<String> keywords;
    private Boolean active;

    @DBRef
    private List<Teacher> teachers;
}
