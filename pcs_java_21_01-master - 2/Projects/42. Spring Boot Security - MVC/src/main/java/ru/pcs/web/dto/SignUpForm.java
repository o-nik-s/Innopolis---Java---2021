package ru.pcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pcs.web.validation.NotSameNames;
import ru.pcs.web.validation.ValidPassword;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@NotSameNames
public class SignUpForm {
    @Size(min = 4, max =  20)
    @NotBlank
    private String firstName;

    @Size(min = 4, max =  20)
    @NotBlank
    private String lastName;

    @NotBlank
    @ValidPassword
    private String password;

    @Email
    @NotBlank
    private String email;
}
