package ru.pcs.web.services;

import ru.pcs.web.forms.SignUpForm;

/**
 * 09.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface SignUpService {
    void signUpUser(SignUpForm form);
}
