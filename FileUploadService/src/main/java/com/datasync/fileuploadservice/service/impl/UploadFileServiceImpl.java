package com.datasync.fileuploadservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.datasync.fileuploadservice.entity.UploadedFile;
import com.datasync.fileuploadservice.repository.FileRepository;
import com.datasync.fileuploadservice.service.UploadFileService;

public class UploadFileServiceImpl implements UploadFileService {
    
    @Autowired
    FileRepository fileRepository;

    @Override
    public String saveFile(MultipartFile file) {
        try{
            UploadedFile uploadedFile=new UploadedFile();
            uploadedFile.setFile(file);
            fileRepository.save(uploadedFile);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "file saved successfully!!";
    }

}
