package com.example.demo.controllers;

import com.example.demo.response.ResponseObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("{id}")
    public ResponseObject<Boolean> testSwagger(@PathVariable String id) {
        return new ResponseObject<>(true);
    }
}
