package com.datasync.fileuploadservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.datasync.fileuploadservice.service.impl.UploadFileServiceImpl;

@RestController
@RequestMapping("/file")
public class FileUploadController {
    
    @Autowired
    UploadFileServiceImpl fileservice;

    //endpoint to recieve file
    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        
        //if file is empty
        if(file.isEmpty()){
            return ResponseEntity.badRequest().body("File is Empty!! please select appropriate file...");
        }
        
        //saving file
        fileservice.saveFile(file);

        return ResponseEntity.ok("File Uploaded Successfully!! ");
    }

}
