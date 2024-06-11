package com.intcomex.backendintcomex.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleController {

    @GetMapping
    public ResponseEntity<String> holaMundo(){
        return ResponseEntity.ok("Hello from another world");
    }
}
