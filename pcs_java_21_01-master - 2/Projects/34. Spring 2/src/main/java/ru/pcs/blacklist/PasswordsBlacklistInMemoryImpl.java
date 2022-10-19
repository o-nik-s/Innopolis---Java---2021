package ru.pcs.blacklist;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class PasswordsBlacklistInMemoryImpl implements PasswordsBlacklist {
    private static final List<String> BAD_PASSWORDS = Arrays.asList("qwerty007", "qwerty008", "123");

    @Override
    public boolean contains(String password) {
        return BAD_PASSWORDS.contains(password);
    }
}
