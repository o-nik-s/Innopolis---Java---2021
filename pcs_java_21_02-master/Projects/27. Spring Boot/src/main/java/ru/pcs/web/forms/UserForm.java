package ru.pcs.web.forms;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * 03.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class UserForm {
    @NotEmpty
    @Length(max = 10)
    private String firstName;
    @NotEmpty
    @Length(max = 10)
    private String lastName;
}
