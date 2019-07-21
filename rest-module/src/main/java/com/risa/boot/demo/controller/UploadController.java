package com.risa.boot.demo.controller;

import com.google.common.io.CountingOutputStream;
import com.risa.boot.demo.entity.FileInf;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@Api(value = "Контроллер загрузки", tags = {"REST контроллер файлов"})
public class UploadController {
    private static final String uploadingDirectory = System.getProperty("user.dir") + "/uploadingDir/";

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
   @ResponseBody

    public ResponseEntity<FileInf> upload(@RequestParam("file") MultipartFile inputFile) {
        FileInf fileInfo = new FileInf();
        HttpHeaders headers = new HttpHeaders();
        if (!inputFile.isEmpty()) {
            try {
                String originalFilename = inputFile.getOriginalFilename();
                File destinationFile = new File(uploadingDirectory + originalFilename);
                inputFile.transferTo(destinationFile);
                fileInfo.setFileName(destinationFile.getPath());
                headers.add("File Uploaded Successfully - ", originalFilename);
                return new ResponseEntity<FileInf>(fileInfo, headers, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<FileInf>(HttpStatus.BAD_REQUEST);
            }
        }else{
            return new ResponseEntity<FileInf>(HttpStatus.BAD_REQUEST);
        }
    }

}










