package ru.pcs.web.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.dto.SignUpForm;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.repositories.AccountsRepositoryJdbcImpl;
import ru.pcs.web.services.AccountsService;
import ru.pcs.web.services.AccountsServiceImpl;
import ru.pcs.web.services.SignUpService;
import ru.pcs.web.services.SignUpServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/accounts/json")
public class AccountsJsonServlet extends HttpServlet {

    private AccountsService accountsService;
    private SignUpService signUpService;

    private ObjectMapper objectMapper;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        this.accountsService = new AccountsServiceImpl(accountsRepository);
        this.signUpService = new SignUpServiceImpl(accountsRepository);
        this.objectMapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AccountDto> accounts = accountsService.searchByEmail(request.getParameter("email"));
        response.setContentType("application/json");
        String json = objectMapper.writeValueAsString(accounts);
        response.getWriter().println(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String body = request.getReader().readLine();
        SignUpForm signUpForm = objectMapper.readValue(body, SignUpForm.class);
        signUpService.signUp(signUpForm);
        response.getWriter().println(objectMapper.writeValueAsString(accountsService.getAll()));
    }
}
