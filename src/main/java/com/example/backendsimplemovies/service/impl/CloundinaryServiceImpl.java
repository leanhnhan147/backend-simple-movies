package com.example.backendsimplemovies.service.impl;

import com.cloudinary.Cloudinary;
import com.example.backendsimplemovies.service.CloundinaryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Map;

@Service
public class CloundinaryServiceImpl implements CloundinaryService {

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public Map uploadFile(MultipartFile file){

        try {
            Map data = cloudinary.uploader().upload(file.getBytes(), Map.of());
            return data;
        }catch (IOException e) {
            throw new RuntimeException("Image uploading fail.");
        }
    }
}

