package ru.pcs.web.servlets;

import ru.pcs.web.dto.AccountDto;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.repositories.AccountsRepositoryJdbcImpl;
import ru.pcs.web.services.AccountsService;
import ru.pcs.web.services.AccountsServiceImpl;

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
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/accounts")
public class AccountsServlet extends HttpServlet {

    private AccountsService accountsService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        this.accountsService = new AccountsServiceImpl(accountsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AccountDto> accounts = accountsService.getAll();
        request.setAttribute("accounts", accounts);
        request.getRequestDispatcher("jsp/accounts.jsp").forward(request, response);
    }
}
