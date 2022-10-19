package ru.pcs.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("byLength")
public class PasswordValidatorByLengthImpl implements PasswordValidator {


    private final int minPasswordLength;

    public PasswordValidatorByLengthImpl(@Value("${passwordValidator.byLength.minLength}") int minPasswordLength) {
        this.minPasswordLength = minPasswordLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minPasswordLength) {
            throw new IllegalArgumentException("Длина пароля не соответствует требованиям");
        }
    }
}
