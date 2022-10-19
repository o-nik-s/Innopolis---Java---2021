package ru.pcs.blacklist;

/**
 * 29.10.2021
 * 33. Spring
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface PasswordsBlacklist {
    boolean contains(String password);
}
