package ru.pcs.rmi.services;

import org.springframework.stereotype.Component;
import ru.pcs.rmi.dto.UserDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 18.11.2021
 * RMI
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
public class UsersServiceImpl implements UsersService {

    @Override
    public List<UserDto> getUsersLimit(int count) {
        return Stream.of(
                UserDto.builder().firstName("User 1").lastName("User 1").build(),
                UserDto.builder().firstName("User 2").lastName("User 2").build(),
                UserDto.builder().firstName("User 3").lastName("User 3").build(),
                UserDto.builder().firstName("User 4").lastName("User 4").build())
                .limit(count).collect(Collectors.toList());
    }
}
