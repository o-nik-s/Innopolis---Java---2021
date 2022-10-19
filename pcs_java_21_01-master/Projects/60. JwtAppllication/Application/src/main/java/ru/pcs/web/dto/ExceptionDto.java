package ru.pcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 17.11.2021
 * 44. Spring Boot Security - REST
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
public class ExceptionDto {
    private String message;
}
