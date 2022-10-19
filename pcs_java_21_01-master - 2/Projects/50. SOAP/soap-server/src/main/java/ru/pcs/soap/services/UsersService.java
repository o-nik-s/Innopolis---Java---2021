package ru.pcs.soap.services;

import com.my.service.User;

import java.util.List;

/**
 * 18.11.2021
 * RMI
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<User> getUsersLimit(int count);
}
