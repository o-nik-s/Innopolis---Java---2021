package ru.pcs.validators;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EmailValidatorByLengthImpl implements EmailValidator {

    private int minEmailLength;

    public EmailValidatorByLengthImpl(int minEmailLength) {
        this.minEmailLength = minEmailLength;
    }

    @Override
    public void validate(String email) {
        if (email.length() < minEmailLength) {
            throw new IllegalArgumentException("Длина Email не соответствует требованиям");
        }
    }
}
