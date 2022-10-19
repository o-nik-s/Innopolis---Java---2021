package ru.pcs.validators;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordValidatorByLengthImpl implements PasswordValidator {

    private int minPasswordLength;

    public PasswordValidatorByLengthImpl(int minPasswordLength) {
        this.minPasswordLength = minPasswordLength;
    }

    @Override
    public void validate(String password) {
        if (password.length() < minPasswordLength) {
            throw new IllegalArgumentException("Длина пароля не соответствует требованиям");
        }
    }
}
