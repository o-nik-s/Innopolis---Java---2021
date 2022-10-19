package ru.pcs.web.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.pcs.web.repositories.AccountsRepository;
import ru.pcs.web.security.filters.TokenAuthenticationFilter;
import ru.pcs.web.security.filters.TokenAuthorizationFilter;

/**
 * 15.11.2021
 * Spring Boot Security - REST
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    public static final String API = "/api";
    public static final String LOGIN_FILTER_PROCESSES_URL = API + "/login";
    public static final String STUDENTS_API = API + "/students";

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserDetailsService accountUserDetailsService;

    @Autowired
    private AccountsRepository accountsRepository;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountUserDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(authenticationManagerBean(),
                objectMapper, accountsRepository);
        tokenAuthenticationFilter.setFilterProcessesUrl(LOGIN_FILTER_PROCESSES_URL);

        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilter(tokenAuthenticationFilter);
        http.addFilterBefore(new TokenAuthorizationFilter(accountsRepository, objectMapper), 
                UsernamePasswordAuthenticationFilter.class);
        
        http.authorizeRequests()
                .antMatchers("/api/login/**").permitAll()
                .antMatchers(HttpMethod.POST, STUDENTS_API).hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, STUDENTS_API).hasAuthority("ADMIN")
                .antMatchers(HttpMethod.DELETE, STUDENTS_API).hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET, STUDENTS_API).authenticated();

    }
}