package ru.pcs.validators;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class PasswordValidatorByCharactersImpl implements PasswordValidator {
    @Override
    public void validate(String password) {
        if (password.indexOf('&') == -1 ||
                password.indexOf('!') == -1 ||
                password.indexOf('#') == -1) {
            throw new IllegalArgumentException("Пароль не содержит спец. символов");
        }
    }
}
