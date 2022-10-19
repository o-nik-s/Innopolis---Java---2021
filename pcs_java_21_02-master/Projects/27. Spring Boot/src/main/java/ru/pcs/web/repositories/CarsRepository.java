package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.Car;

import java.util.List;

/**
 * 05.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CarsRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByOwner_Id(Integer id);
    List<Car> findAllByOwnerIsNull();

    List<Car> findAllByColorAndModel(String color, String model);
}
