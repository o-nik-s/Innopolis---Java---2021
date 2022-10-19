package ru.pcs.web.servlets;

import ru.pcs.web.dto.FileDto;
import ru.pcs.web.repositories.FileInfoRepository;
import ru.pcs.web.repositories.FileInfoRepositoryJdbcImpl;
import ru.pcs.web.services.FilesService;
import ru.pcs.web.services.FilesServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import java.io.*;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@WebServlet("/filesUpload")
@MultipartConfig
public class FilesUploadServlet extends HttpServlet {

    private FilesService filesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();
        DataSource dataSource = (DataSource) servletContext.getAttribute("dataSource");
        FileInfoRepository fileInfoRepository = new FileInfoRepositoryJdbcImpl(dataSource);
        this.filesService = new FilesServiceImpl(fileInfoRepository);
        this.filesService.setStoragePath((String) servletContext.getAttribute("storagePath"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/filesUpload.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader descriptionReader = new BufferedReader(
                new InputStreamReader(request.getPart("description").getInputStream()));

        Part filePart = request.getPart("file");

        FileDto form = FileDto.builder()
                .description(descriptionReader.readLine())
                .fileName(filePart.getSubmittedFileName())
                .size(filePart.getSize())
                .mimeType(filePart.getContentType())
                .fileStream(filePart.getInputStream())
                .build();

        filesService.upload(form);
    }
}
