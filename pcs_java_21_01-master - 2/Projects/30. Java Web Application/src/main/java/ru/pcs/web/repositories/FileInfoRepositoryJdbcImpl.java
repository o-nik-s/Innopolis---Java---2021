package ru.pcs.web.repositories;

import ru.pcs.web.models.Account;
import ru.pcs.web.models.FileInfo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;
import java.util.function.Function;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class FileInfoRepositoryJdbcImpl implements FileInfoRepository {

    //language=SQL
    private static final String SQL_INSERT = "insert into " +
            "file_info(original_file_name, storage_file_name, size, mime_type, description) " +
            "values(?, ?, ?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_STORAGE_NAME = "select * from file_info where storage_file_name = ?";

    private final DataSource dataSource;

    public FileInfoRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    private static final Function<ResultSet, FileInfo> fileInfoMapper = row -> {
        try {
            return FileInfo.builder()
                    .id(row.getLong("id"))
                    .storageFileName(row.getString("storage_file_name"))
                    .description(row.getString("description"))
                    .originalFileName(row.getString("original_file_name"))
                    .mimeType(row.getString("mime_type"))
                    .size(row.getLong("size"))
                    .build();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    };

    @Override
    public void save(FileInfo file) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, file.getOriginalFileName());
            statement.setString(2, file.getStorageFileName());
            statement.setLong(3, file.getSize());
            statement.setString(4, file.getMimeType());
            statement.setString(5, file.getDescription());

            int affectedRows = statement.executeUpdate();

            if (affectedRows != 1) {
                throw new SQLException("Can't insert FileInfo");
            }

            ResultSet generatedKeys = statement.getGeneratedKeys();

            if (generatedKeys.next()) {
                file.setId(generatedKeys.getLong("id"));
            } else {
                throw new SQLException("Can't get id");
            }

        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public Optional<FileInfo> findByStorageName(String storageFileName) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_STORAGE_NAME)) {
            statement.setString(1, storageFileName);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(fileInfoMapper.apply(resultSet));
                }

                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
