package ru.pcs.validators;

import java.util.regex.Pattern;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class EmailValidatorRegexImpl implements EmailValidator {

    private Pattern pattern;

    public void setPattern(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public void validate(String email) {
        if (!pattern.matcher(email).find()) {
            throw new IllegalArgumentException("Email не соответствует формату");
        }
    }
}
