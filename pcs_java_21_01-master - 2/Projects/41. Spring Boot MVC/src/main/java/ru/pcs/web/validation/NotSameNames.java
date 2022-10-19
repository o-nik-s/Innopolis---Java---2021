package ru.pcs.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 08.11.2021
 * 41. Spring Boot MVC
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Constraint(validatedBy = NamesValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface NotSameNames {
    String message() default "names are same";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default  {};
}
