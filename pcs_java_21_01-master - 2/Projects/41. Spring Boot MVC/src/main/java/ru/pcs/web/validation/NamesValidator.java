package ru.pcs.web.validation;

import ru.pcs.web.dto.SignUpForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 08.11.2021
 * 41. Spring Boot MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class NamesValidator implements ConstraintValidator<NotSameNames, SignUpForm> {

    @Override
    public boolean isValid(SignUpForm object, ConstraintValidatorContext context) {
        return !object.getFirstName().equals(object.getLastName());
    }
}
