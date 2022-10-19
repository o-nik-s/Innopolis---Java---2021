package ru.pcs.soap.services;

import com.my.service.User;
import org.springframework.stereotype.Component;

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
    public List<User> getUsersLimit(int count) {
        User user1 = new User();
        user1.setFirstName("User 1");
        user1.setLastName("User 1");

        User user2 = new User();
        user2.setFirstName("User 2");
        user2.setLastName("User 2");

        User user3 = new User();
        user3.setFirstName("User 3");
        user3.setLastName("User 3");

        return Stream.of(user1, user2, user3).limit(count).collect(Collectors.toList());


    }
}
