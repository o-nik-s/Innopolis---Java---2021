package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.pcs.web.exceptions.UserNotFoundException;
import ru.pcs.web.forms.UserForm;
import ru.pcs.web.models.Car;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.CarsRepository;
import ru.pcs.web.repositories.UsersRepository;

import java.util.List;
import java.util.Optional;

/**
 * 03.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Component
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final CarsRepository carsRepository;

//    @Autowired
//    public UsersServiceImpl(UsersRepository usersRepository, CarsRepository carsRepository) {
//        this.usersRepository = usersRepository;
//        this.carsRepository = carsRepository;
//    }

    @Override
    public void addUser(UserForm form) {
        User user = User.builder()
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .build();

        usersRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepository.deleteById(userId);
    }

    @Override
    public User getUser(Integer userId) {
        return usersRepository.findById(userId).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<Car> getCarsByUser(Integer userId) {
        return carsRepository.findAllByOwner_Id(userId);
    }

    @Override
    public List<Car> getCarsWithoutOwner() {
        return carsRepository.findAllByOwnerIsNull();
    }

    @Override
    public void addCarToUser(Integer userId, Integer carId) {
        User user = usersRepository.getById(userId);
        Car car = carsRepository.getById(carId);
        car.setOwner(user);
        carsRepository.save(car);
    }

    @Override
    public void update(Integer userId, UserForm userForm) {
        User user = usersRepository.getById(userId);
        user.setFirstName(userForm.getFirstName());
        user.setLastName(userForm.getLastName());
        usersRepository.save(user);
    }
}
