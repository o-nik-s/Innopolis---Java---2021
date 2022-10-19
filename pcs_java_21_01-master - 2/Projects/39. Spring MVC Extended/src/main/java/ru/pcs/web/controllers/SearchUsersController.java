package ru.pcs.web.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.services.SearchService;

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
@RequestMapping("/search")
public class SearchUsersController {

    private final SearchService searchService;

    @RequestMapping()
    public String getSearchPage() {
        return "searchUsers";
    }

    @RequestMapping("/users")
    @ResponseBody
    public List<AccountDto> search(@RequestParam("email") String email) {
        return searchService.searchUsersByEmail(email);
    }
}
