package ru.pcs.web.security.details;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.pcs.web.models.Account;
import ru.pcs.web.repositories.AccountsRepository;

import java.util.Optional;

/**
 * 10.11.2021
 * 42. Spring Boot Security - MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Service
public class AccountUserDetailsService implements UserDetailsService {

    private final AccountsRepository accountsRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return new AccountUserDetails(
                accountsRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")));
    }
}
