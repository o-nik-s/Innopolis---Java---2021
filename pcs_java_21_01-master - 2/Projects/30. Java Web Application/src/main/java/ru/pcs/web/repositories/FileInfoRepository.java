package ru.pcs.web.repositories;

import ru.pcs.web.models.FileInfo;

import java.util.Optional;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FileInfoRepository {
    void save(FileInfo file);

    Optional<FileInfo> findByStorageName(String storageFileName);
}
