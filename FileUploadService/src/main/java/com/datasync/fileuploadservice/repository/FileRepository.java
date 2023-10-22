package com.datasync.fileuploadservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import com.datasync.fileuploadservice.entity.UploadedFile;

public interface FileRepository extends JpaRepository<UploadedFile, MultipartFile> {
    
}
