package ru.pcs.web.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import ru.pcs.web.models.FileInfo;
import ru.pcs.web.models.User;
import ru.pcs.web.repositories.FilesInfoRepository;
import ru.pcs.web.repositories.UsersRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * 12.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Component
public class FilesServiceImpl implements FilesService {

    @Value("${files.storage.path}")
    private String storageFolder;

    private final FilesInfoRepository filesInfoRepository;
    private final UsersRepository usersRepository;

    @Override
    public void saveFile(Integer ownerId, String description, MultipartFile multipartFile) {
        User user = usersRepository.getById(ownerId);
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.indexOf("."));

        FileInfo fileInfo = FileInfo.builder()
                .originalName(multipartFile.getOriginalFilename())
                .mimeType(multipartFile.getContentType())
                .description(description)
                .uploadDateTime(LocalDateTime.now())
                .storageName(UUID.randomUUID() + extension)
                .size(multipartFile.getSize())
                .owner(user)
                .build();

        filesInfoRepository.save(fileInfo);

        try {
            Files.copy(multipartFile.getInputStream(), Paths.get(storageFolder, fileInfo.getStorageName()));
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public void addFileToResponse(String fileName, HttpServletResponse response) {
        FileInfo fileInfo = filesInfoRepository.findByStorageName(fileName);

        response.setContentType(fileInfo.getMimeType());
        response.setContentLength(fileInfo.getSize().intValue());
        response.setHeader("Content-Disposition", "filename=\"" + fileInfo.getOriginalName() + "\"");
        try {
            Files.copy(Paths.get(storageFolder, fileInfo.getStorageName()), response.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
