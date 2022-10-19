package ru.pcs.web.servlets;

import ru.pcs.web.dto.SignInForm;
import ru.pcs.web.filters.AuthenticationFilter;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.repositories.AccountsRepositoryJdbcImpl;
import ru.pcs.web.services.SignInService;
import ru.pcs.web.services.SignInServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

    private SignInService signInService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        AccountsRepository accountsRepository = new AccountsRepositoryJdbcImpl(dataSource);
        this.signInService = new SignInServiceImpl(accountsRepository);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/signIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignInForm form = SignInForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        if (signInService.doAuthenticate(form)) {
            // создаем сессию для запросов пользователя (если сессия уже была, заменяем ее)
            HttpSession session = request.getSession(true);
            session.setAttribute(AuthenticationFilter.DEFAULT_AUTHENTICATED_ATTRIBUTE_NAME, true);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/signIn?error");
        }

    }
}
