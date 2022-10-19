package ru.pcs.web.models;

import lombok.*;

import java.time.LocalDateTime;
import java.util.StringJoiner;

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

    private String firstName;
    private String lastName;

    private String email;
    private String password;

}
