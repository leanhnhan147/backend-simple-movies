package com.example.backendsimplemovies.config;

import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary getCloudinary(){
        Map<String,String> config = new HashMap<>();
        config.put("cloud_name", "dntkdzwei");
        config.put("api_key", "671223863532126");
        config.put("api_secret", "1sy-fBdFafsxQVWuaGqo9S5DHvE");
        return new Cloudinary(config);
    }
}
