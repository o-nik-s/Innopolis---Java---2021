package ru.pcs.education.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.pcs.education.dto.CoursesDto;

import java.util.List;

/**
 * 17.11.2021
 * education-service
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@FeignClient("courses-service")
public interface CoursesClient {
    @RequestMapping("/courses")
    List<CoursesDto> getCourses();
}
