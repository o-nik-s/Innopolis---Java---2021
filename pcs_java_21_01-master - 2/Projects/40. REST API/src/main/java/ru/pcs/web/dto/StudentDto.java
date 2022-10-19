package ru.pcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pcs.web.models.Student;

import java.util.List;
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
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;

    public static StudentDto from(Student student) {
        return StudentDto.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();
    }

    public static List<StudentDto> from(List<Student> students) {
        return students.stream().map(StudentDto::from).collect(Collectors.toList());
    }
}
