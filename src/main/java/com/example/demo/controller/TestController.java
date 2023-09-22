package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/test")
//@RequiredArgsConstructor
public class TestController {

    @Autowired
    private DynamodbClientSample dynamodbClientSample;

    @GetMapping
    public String list() throws IOException {
//        s3ClientSample.readFile();
        dynamodbClientSample.listTables();
        return "hi";
    }

}
