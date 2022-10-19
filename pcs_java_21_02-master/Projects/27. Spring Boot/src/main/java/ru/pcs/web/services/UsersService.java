package ru.pcs.web.services;

import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.Car;
import ru.pcs.web.models.User;

import java.util.List;

/**
 * 03.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersService {
    void addUser(UserForm form);
    List<User> getAllUsers();

    void deleteUser(Integer userId);

    User getUser(Integer userId);

    List<Car> getCarsByUser(Integer userId);

    List<Car> getCarsWithoutOwner();

    void addCarToUser(Integer userId, Integer carId);

    void update(Integer userId, UserForm userForm);
}
