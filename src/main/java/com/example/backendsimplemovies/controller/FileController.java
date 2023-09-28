package com.example.backendsimplemovies.controller;

import com.example.backendsimplemovies.service.CloundinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;
@RestController
@RequestMapping("/v1/files")
public class FileController {

    @Autowired
    CloundinaryService cloundinaryService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestBody MultipartFile file){
        Map data = cloundinaryService.uploadFile(file);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
