package ru.pcs.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 10.11.2021
 * 42. Spring Boot Security - MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
@RequestMapping("/")
public class RootController {
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public String getRootPage() {
        return "redirect:/profile";
    }
}
