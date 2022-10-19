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
@Component("emailValidatorByLength")
public class EmailValidatorByLengthImpl implements EmailValidator {

    private final int minEmailLength;

    public EmailValidatorByLengthImpl(@Value("${emailValidator.ByLength.minLength}") int minEmailLength) {
        this.minEmailLength = minEmailLength;
    }

    @Override
    public void validate(String email) {
        if (email.length() < minEmailLength) {
            throw new IllegalArgumentException("Длина Email не соответствует требованиям");
        }
    }
}
