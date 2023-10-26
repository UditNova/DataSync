package com.dataprocessing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dataprocessing.service.EmployeeService;

@RestController
@RequestMapping("/database")
public class EmployeeController {
    
    @Autowired
    EmployeeService service;

    @PostMapping("/save")
    public ResponseEntity<String> save_data( @RequestParam("file") MultipartFile file){
        String success=service.saveEmployee(file);
        
        return ResponseEntity.ok().body(success);
    }

}
