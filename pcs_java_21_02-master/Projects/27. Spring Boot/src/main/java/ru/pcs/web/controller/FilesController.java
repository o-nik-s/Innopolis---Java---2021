package ru.pcs.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.pcs.web.services.FilesService;

import javax.servlet.http.HttpServletResponse;

/**
 * 12.12.2021
 * 27. Spring Boot
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@RequiredArgsConstructor
@Controller
public class FilesController {

    private final FilesService filesService;

    @GetMapping("/files/upload")
    public String getFilesUploadPage() {
        return "files_upload";
    }

    // GET http://localhost/files/faf94d48-aa7a-440b-830f-0661213685cd.jpg
    @GetMapping("/files/{file:.+}")
    public void getFile(@PathVariable("file") String fileName, HttpServletResponse response) {
        filesService.addFileToResponse(fileName, response);
    }

    @PostMapping("/files/upload")
    public String uploadFile(@AuthenticationPrincipal(expression = "id") Integer userId, @RequestParam("description") String description, @RequestParam("file") MultipartFile multipartFile) {
        filesService.saveFile(userId, description, multipartFile);
        return "redirect:/files/upload";
    }
}
