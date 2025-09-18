package com.wanderway.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/gallery")
public class ImageController {

    private static final String UPLOAD_DIR = "uploads/";

    @GetMapping
    public String gallery(Model model) throws IOException {
        File folder = new File(UPLOAD_DIR);
        if (!folder.exists()) folder.mkdirs();

        model.addAttribute("images", Files.list(Paths.get(UPLOAD_DIR))
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList()));

        return "gallery";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            File folder = new File(UPLOAD_DIR);
            if (!folder.exists()) folder.mkdirs();

            Path filePath = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
            Files.write(filePath, file.getBytes());
        }
        return "redirect:/gallery";
    }
}
