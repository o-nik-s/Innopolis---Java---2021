package ru.pcs.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 03.11.2021
 * 39. Spring MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class SignInController {

    @RequestMapping("/signIn")
    public String getSignInPage() {
        return "signIn";
    }
}
