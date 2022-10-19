package ru.pcs.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.services.AccountsService;

import java.util.List;

/**
 * 03.11.2021
 * 39. Spring MVC Extended
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Controller
public class UsersController {

    private final AccountsService accountsService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {
        model.addAttribute("accounts", accountsService.getAll());
        return "accounts";
    }

    @RequestMapping(value = "/users/json", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<AccountDto> addUser(@RequestBody AccountDto user) {
        accountsService.addUser(user);
        return accountsService.getAll();
    }

    @RequestMapping("/users/{user-id}/information")
    public String getUserInformation(Model model, @PathVariable("user-id") Long userId) {
        model.addAttribute("account", accountsService.getInformation(userId));
        return "userInformation";
    }
}
