package ru.pcs.mongo.spring;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Course {
    private String _id;
    private Integer studentsCount;
    private Integer hours;
    private List<String> keywords;
    private Map<String, String> teachers;
    private Boolean active;
}
