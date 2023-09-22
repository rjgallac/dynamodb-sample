package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;
import software.amazon.awssdk.services.dynamodb.model.ListTablesRequest;
import software.amazon.awssdk.services.dynamodb.model.ListTablesResponse;
import software.amazon.awssdk.services.dynamodb.model.PutItemRequest;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
public class DynamodbClientSample {

    @Autowired
    private DynamoDbClient dynamoDbClient;


    public void listTables() throws IOException {
        ListTablesResponse listTablesResponse = dynamoDbClient.listTables();
        System.out.println("here");
    }

    public void addItem() {
        HashMap<String, AttributeValue> itemValues = new HashMap<>();
        itemValues.put("Artist", AttributeValue.builder().s("keyVal").build());
        itemValues.put("SongTitle", AttributeValue.builder().s("songTitleVal").build());
        PutItemRequest build = PutItemRequest.builder().tableName("Music").item(itemValues).build();
        dynamoDbClient.putItem(build);
    }

}
