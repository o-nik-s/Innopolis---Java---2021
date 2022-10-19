package ru.pcs.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * 04.10.2021
 * 24. JDBC Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String password;
    private Integer age;

    @OneToMany(mappedBy = "owner")
    private List<Car> cars;
}
