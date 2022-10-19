package ru.pcs.web.aspects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.pcs.web.dto.ExceptionDto;

import javax.persistence.EntityNotFoundException;

/**
 * 17.11.2021
 * 44. Spring Boot Security - REST
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex) {
        return ResponseEntity.status(404).body(new ExceptionDto(ex.getMessage()));
    }
}
