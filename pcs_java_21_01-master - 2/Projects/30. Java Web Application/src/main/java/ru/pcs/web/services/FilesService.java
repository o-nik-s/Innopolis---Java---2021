package ru.pcs.web.services;

import ru.pcs.web.dto.FileDto;
import ru.pcs.web.models.FileInfo;

import java.io.OutputStream;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FilesService {
    void upload(FileDto form);

    void setStoragePath(String path);

    FileDto getFile(String storageFileName);

    void writeFile(FileDto file, OutputStream outputStream);
}
