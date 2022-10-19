package ru.pcs.education.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.education.dto.CoursesDto;
import ru.pcs.education.dto.UserDto;

import java.util.List;

/**
 * 17.11.2021
 * education-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@FeignClient("users-service")
public interface UsersClient {
    @RequestMapping("/users")
    List<UserDto> getUsers();
}
