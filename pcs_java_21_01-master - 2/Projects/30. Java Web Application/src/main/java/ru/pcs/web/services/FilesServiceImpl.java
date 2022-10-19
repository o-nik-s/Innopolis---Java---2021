package ru.pcs.web.services;

import ru.pcs.web.dto.FileDto;
import ru.pcs.web.models.FileInfo;
import ru.pcs.web.repositories.FileInfoRepository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FilesServiceImpl implements FilesService {

    private final FileInfoRepository fileInfoRepository;
    private String storagePath;

    public FilesServiceImpl(FileInfoRepository fileInfoRepository) {
        this.fileInfoRepository = fileInfoRepository;
    }

    @Override
    public void upload(FileDto form) {
        String fileName = form.getFileName();
        String extension = fileName.substring(fileName.lastIndexOf("."));

        FileInfo fileInfo = FileInfo.builder()
                .originalFileName(fileName)
                .storageFileName(UUID.randomUUID() + extension)
                .description(form.getDescription())
                .mimeType(form.getMimeType())
                .size(form.getSize())
                .build();

        fileInfoRepository.save(fileInfo);

        if (storagePath != null) {
            try {
                Files.copy(form.getFileStream(), Paths.get(storagePath + fileInfo.getStorageFileName()));
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
    }

    @Override
    public void setStoragePath(String path) {
        this.storagePath = path;
    }

    @Override
    public FileDto getFile(String storageFileName) {
        Optional<FileInfo> fileInfoOptional = fileInfoRepository.findByStorageName(storageFileName);
        if (fileInfoOptional.isPresent()) {
            FileDto file = FileDto.from(fileInfoOptional.get());
            file.setFileName(storageFileName);
            return file;
        }
        return null;
    }

    @Override
    public void writeFile(FileDto file, OutputStream outputStream) {
        try {
            Files.copy(Paths.get(storagePath + "\\" + file.getFileName()), outputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
