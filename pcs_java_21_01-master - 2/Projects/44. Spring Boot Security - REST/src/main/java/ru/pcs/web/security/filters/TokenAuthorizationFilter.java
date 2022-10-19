package ru.pcs.web.security.filters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.security.config.SecurityConfiguration;
import ru.pcs.web.security.details.AccountUserDetails;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

/**
 * 15.11.2021
 * Spring Boot Security - REST
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
public class TokenAuthorizationFilter extends OncePerRequestFilter {

    private final AccountsRepository accountsRepository;
    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().equals(SecurityConfiguration.LOGIN_FILTER_PROCESSES_URL)) {
            filterChain.doFilter(request, response);
        } else {
            String tokenHeader = request.getHeader("Authorization");
            if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
                String token = tokenHeader.substring("Bearer ".length());
                Optional<Account> account = accountsRepository.findByToken(token);

                if (account.isPresent()) {
                    AccountUserDetails userDetails = new AccountUserDetails(account.get());
                    UsernamePasswordAuthenticationToken authenticationToken =
                            new UsernamePasswordAuthenticationToken(token, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    filterChain.doFilter(request, response);
                } else {
                    logger.warn("Wrong token");
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                    objectMapper.writeValue(response.getWriter(), Collections.singletonMap("error", "user not found with token"));
                }
            } else {
                logger.warn("Token is missing");
                filterChain.doFilter(request, response);
            }
        }
    }
}
