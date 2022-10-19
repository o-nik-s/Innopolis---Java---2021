package ru.pcs.web.services;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * 12.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FilesService {
    void saveFile(Integer ownerId, String description, MultipartFile multipartFile);

    void addFileToResponse(String fileName, HttpServletResponse response);
}
