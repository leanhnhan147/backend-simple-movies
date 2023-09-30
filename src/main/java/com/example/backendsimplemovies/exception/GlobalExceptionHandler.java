package com.example.backendsimplemovies.exception;

import com.example.backendsimplemovies.dto.ApiMessageDto;
import com.example.backendsimplemovies.form.ErrorForm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    final ObjectMapper mapper = new ObjectMapper();

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<ApiMessageDto<String>> globalExceptionHandler(NotFoundException ex) {
        ApiMessageDto<String> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setCode("ERROR");
        apiMessageDto.setResult(false);
        apiMessageDto.setMessage(ex.getMessage());
        return new ResponseEntity<>(apiMessageDto, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiMessageDto<List<ErrorForm>> exceptionHandler(Exception ex) {
        ApiMessageDto<List<ErrorForm>> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setCode("ERROR");
        apiMessageDto.setResult(false);
        if(ex instanceof MyBindingException){
            try {
                List<ErrorForm> errorForms = Arrays.asList(mapper.readValue(ex.getMessage(), ErrorForm[].class));
                apiMessageDto.setData(errorForms);
                apiMessageDto.setMessage("Invalid form");
            }catch (Exception e){
                System.out.println(ex.getMessage());
            }
        }else{
            apiMessageDto.setMessage("[Ex2]: "+ex.getMessage());
        }
        return apiMessageDto;
    }
}
