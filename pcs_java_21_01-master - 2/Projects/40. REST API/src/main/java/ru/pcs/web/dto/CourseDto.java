package ru.pcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pcs.web.models.Course;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 05.11.2021
 * 40. REST API
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String title;

    public static CourseDto from(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .build();
    }

    public static List<CourseDto> from(Set<Course> courses) {
        return courses.stream().map(CourseDto::from).collect(Collectors.toList());
    }
}
