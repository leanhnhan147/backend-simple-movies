package com.example.backendsimplemovies.service;


import org.springframework.web.multipart.MultipartFile;
import java.util.Map;

public interface CloundinaryService {

   Map uploadFile(MultipartFile file);
}
