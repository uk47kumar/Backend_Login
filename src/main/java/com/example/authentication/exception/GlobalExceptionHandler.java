package com.example.authentication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> notFoundHandler(ResourceNotFoundException e){
        Map<String,Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("success",false);
        map.put("status", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> notValidHandler(MethodArgumentNotValidException e){
        Map<String,String> map = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            map.put(fieldName,message);
        });
        return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String,Object>> notFoundHandler(ApiException e){
        Map<String,Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("success",true);
        map.put("status", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Map<String,Object>> notFoundHandler(DuplicateException e){
        Map<String,Object> map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("success",true);
        map.put("status", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
}
