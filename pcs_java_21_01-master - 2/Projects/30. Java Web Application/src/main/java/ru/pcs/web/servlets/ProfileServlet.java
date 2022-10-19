package ru.pcs.web.servlets;

import ru.pcs.web.filters.ColorFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 18.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

    private static final int COLOR_COOKIE_MAX_AGE = 60 * 60 * 24 * 365;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageColor = request.getParameter("color");

        if (pageColor != null) {
            request.setAttribute("color", pageColor);
            Cookie cookie = new Cookie(ColorFilter.COLOR_COOKIE_NAME,pageColor);
            cookie.setMaxAge(COLOR_COOKIE_MAX_AGE);
            response.addCookie(cookie);
        }

        request.getRequestDispatcher("/jsp/profile.jsp").forward(request, response);
    }
}
