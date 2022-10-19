package ru.pcs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 10.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Controller
public class ErrorsController {
    @GetMapping("/error/404")
    public String get404Page() {
        return "errors/error_404";
    }
}
