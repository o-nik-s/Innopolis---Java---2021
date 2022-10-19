package ru.pcs.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.pcs.web.dto.SignUpForm;
import ru.pcs.web.services.SignUpService;

/**
 * 03.11.2021
 * 39. Spring MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/signUp")
public class SignUpController {

    private final SignUpService signUpService;

    @RequestMapping()
    public String getSignUpPage() {
        return "signUp";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String signUp(SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
