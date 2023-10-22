package com.datasync.fileuploadservice.entity;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name= "UploadedFile")
public class UploadedFile {
    
    private MultipartFile file;


}
