package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.PostResponse;
import com.example.jsonplaceholder.model.domain.PostDomain;
import com.example.jsonplaceholder.model.placeholder.PostPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    //Domain

    public static PostDomain convertRequestToDomain(PostRequest postRequest) {
        return PostDomain.builder()
                .id(postRequest.getId())
                .userId(postRequest.getUserId())
                .body(postRequest.getBody())
                .title(postRequest.getTitle())
                .build();
    }

    public static PostDomain convertPlaceholderToDomain(PostPlaceholder postPlaceholder) {
        return PostDomain.builder()
                .id(postPlaceholder.getId())
                .userId(postPlaceholder.getUserId())
                .body(postPlaceholder.getBody())
                .title(postPlaceholder.getTitle())
                .build();
    }

    // Response

    public static PostResponse convertToPostResponse(PostDomain post) {
        return PostResponse.builder()
                .id(post.getId())
                .userId(post.getUserId())
                .body(post.getBody())
                .title(post.getTitle())
                .build();

    }

    public static List<PostResponse> generatePostResponseList(List<PostDomain> postList) {
        return postList.stream()
                .map(PostConverter::convertToPostResponse)
                .collect(Collectors.toList());
    }
}
