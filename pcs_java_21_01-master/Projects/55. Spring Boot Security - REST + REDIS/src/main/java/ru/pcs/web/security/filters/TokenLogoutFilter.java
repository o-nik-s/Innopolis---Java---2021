package ru.pcs.web.security.filters;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.pcs.web.repositories.BlackListRepository;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 26.11.2021
 * 55. Spring Boot Security - REST + REDIS
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
public class TokenLogoutFilter extends OncePerRequestFilter {

    private final BlackListRepository blackListRepository;

    private final static RequestMatcher logoutRequest = new AntPathRequestMatcher("/api/logout", "GET");

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (logoutRequest.matches(request)) {
            String tokenHeader = request.getHeader("Authorization");
            if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
                String token = tokenHeader.substring("Bearer ".length());
                blackListRepository.save(token);
                SecurityContextHolder.getContext();
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
