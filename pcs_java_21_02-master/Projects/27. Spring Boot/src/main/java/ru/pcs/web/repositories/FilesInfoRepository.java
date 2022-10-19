package ru.pcs.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pcs.web.models.FileInfo;

/**
 * 12.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface FilesInfoRepository extends JpaRepository<FileInfo, Long> {
    FileInfo findByStorageName(String storageName);
}
