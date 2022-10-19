package ru.pcs.web.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.pcs.web.dto.WrapperResponse;

/**
 * 17.11.2021
 * 44. Spring Boot Security - REST
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Component
@Slf4j
@Aspect
public class TimeAspect {
    @Around(value = "execution(* ru.pcs.web.controllers.StudentsController.*(..))")
    public ResponseEntity<WrapperResponse> addTimeToResponse(ProceedingJoinPoint joinPoint) throws Throwable {
        long before = System.currentTimeMillis();
        Object response = joinPoint.proceed();
        long after = System.currentTimeMillis();
        return ResponseEntity.ok(WrapperResponse.builder()
                .response(((ResponseEntity)response).getBody())
                .time(after - before)
                .build());
    }
}
