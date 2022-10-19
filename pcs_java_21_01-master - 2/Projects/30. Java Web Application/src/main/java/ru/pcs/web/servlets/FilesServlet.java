package ru.pcs.web.servlets;

import ru.pcs.web.dto.FileDto;
import ru.pcs.web.repositories.FileInfoRepository;
import ru.pcs.web.repositories.FileInfoRepositoryJdbcImpl;
import ru.pcs.web.services.FilesService;
import ru.pcs.web.services.FilesServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;

/**
 * 20.10.2021
 * 30. Java Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// GET /files?fileName=1ca51244-d764-463d-ade4-ee9aba3d0ab6.png
@WebServlet("/files")
public class FilesServlet extends HttpServlet {
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
        String storageFileName = request.getParameter("fileName");
        FileDto file = filesService.getFile(storageFileName);
        response.setContentType(file.getMimeType());
        response.setContentLength(file.getSize().intValue());
        response.setHeader("Content-Disposition", "filename=\"" + file.getOriginalFileName() + "\"");
        filesService.writeFile(file, response.getOutputStream());
        response.flushBuffer();
    }
}
