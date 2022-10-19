package ru.pcs.web.services;

import ru.pcs.web.dto.SignInForm;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface SignInService {
    boolean doAuthenticate(SignInForm form);
}
