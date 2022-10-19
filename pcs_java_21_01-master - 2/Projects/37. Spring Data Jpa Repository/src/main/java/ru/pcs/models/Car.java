package ru.pcs.models;

import lombok.*;

import javax.persistence.*;

/**
 * 01.11.2021
 * 37. Spring Data Jpa Repository
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = "owner")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String color;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Account owner;
}
