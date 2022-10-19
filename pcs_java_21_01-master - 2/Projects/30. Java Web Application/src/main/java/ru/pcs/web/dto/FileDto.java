package ru.pcs.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.pcs.web.models.FileInfo;

import java.io.InputStream;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileDto {
    private Long size;
    private String fileName;
    private String mimeType;
    private InputStream fileStream;
    private String description;
    private String originalFileName;

    public static FileDto from(FileInfo fileInfo) {
        return FileDto.builder()
                .description(fileInfo.getDescription())
                .fileName(fileInfo.getOriginalFileName())
                .size(fileInfo.getSize())
                .mimeType(fileInfo.getMimeType())
                .originalFileName(fileInfo.getOriginalFileName())
                .build();
    }
}
