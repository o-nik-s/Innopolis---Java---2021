package ru.pcs.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    private static final List<String> PROTECTED_URIS =
            Arrays.asList("/profile", "/accounts");

    public static final String DEFAULT_AUTHENTICATED_ATTRIBUTE_NAME = "isAuthenticated";

    private static final List<String> NOT_ACCESSED_AFTER_AUTHENTICATION_URIS =
            Arrays.asList("signIn", "signUp");

    private static final String DEFAULT_REDIRECT_URI = "/profile";
    private static final String DEFAULT_SIGN_IN_URI = "/signIn";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // запрос нуждается в защите
        if (isProtected(request)) {
            // делаем проверку аутентификации
            if (isAuthenticated(request)) {
                chain.doFilter(request, response);
            } else {
                response.sendRedirect(DEFAULT_SIGN_IN_URI);
            }
            return;
        }
        if (isAuthenticated(request) && NOT_ACCESSED_AFTER_AUTHENTICATION_URIS.contains(request.getRequestURI())) {
            response.sendRedirect(DEFAULT_REDIRECT_URI);
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean isAuthenticated(HttpServletRequest request) {
        // запрашиваем сессию без создания
        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }

        Boolean result = (Boolean)session.getAttribute(DEFAULT_AUTHENTICATED_ATTRIBUTE_NAME);

        return result != null && result;

    }

    private boolean isProtected(HttpServletRequest request) {
        return PROTECTED_URIS.contains(request.getRequestURI());
    }

    @Override
    public void destroy() {

    }
}
