package com.example.books.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class CheckoutResponseHandler {

    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,Object user, Object responseObj, Double total) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("user", user);
        map.put("books", responseObj);
        map.put("total", total);

        return new ResponseEntity<Object>(map, status);
    }

    public static ResponseEntity<Object> generateErrorResponse(String message, HttpStatus status){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status);

        return new ResponseEntity<Object>(map, status);
    }
}
