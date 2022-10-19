package ru.pcs.rmi.services;

import ru.pcs.rmi.dto.UserDto;

import java.util.List;

/**
 * 18.11.2021
 * RMI
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    List<UserDto> getUsersLimit(int count);
}
