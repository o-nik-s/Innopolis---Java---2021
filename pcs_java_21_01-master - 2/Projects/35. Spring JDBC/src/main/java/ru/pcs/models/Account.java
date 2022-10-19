package ru.pcs.models;

import lombok.*;

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
public class Account {
    private Long id;

    private String email;
    private String password;
    private Integer age;

}
