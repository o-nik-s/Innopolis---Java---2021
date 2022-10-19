package ru.pcs.validators;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component("emailValidatorRegex")
public class EmailValidatorRegexImpl implements EmailValidator {

    private Pattern pattern;

    public void setPattern(@Value("${emailValidator.regex}") String regex) {
        this.pattern = Pattern.compile(regex);
    }

    @Override
    public void validate(String email) {
        if (!pattern.matcher(email).find()) {
            throw new IllegalArgumentException("Email не соответствует формату");
        }
    }
}
