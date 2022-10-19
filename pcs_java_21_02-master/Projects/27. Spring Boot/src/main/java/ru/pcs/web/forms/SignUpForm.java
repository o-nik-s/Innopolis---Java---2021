package ru.pcs.web.forms;

import lombok.Data;

/**
 * 09.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
public class SignUpForm {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
