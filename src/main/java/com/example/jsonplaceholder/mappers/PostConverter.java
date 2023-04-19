package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.PostResponse;
import com.example.jsonplaceholder.model.domain.PostDomain;
import com.example.jsonplaceholder.model.placeholder.PostPlaceholder;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    //Domain

    public static PostDomain convertPostRequestToDomain(PostRequest postRequest) {
        return PostDomain.builder()
                .id(postRequest.getId())
                .body(postRequest.getBody())
                .title(postRequest.getTitle())
                .build();
    }

    public static PostDomain convertPostPlaceholderToDomain(PostPlaceholder postPlaceholder) {
        return PostDomain.builder()
                .id(postPlaceholder.getId())
                .body(postPlaceholder.getBody())
                .title(postPlaceholder.getTitle())
                .build();
    }

    // Response

    public static PostResponse convertPostDomainToResponse(PostDomain post) {
        return PostResponse.builder()
                .id(post.getId())
                .body(post.getBody())
                .title(post.getTitle())
                .build();

    }

    public static List<PostResponse> generatePostDomainListToPostResponseList(List<PostDomain> postList) {
        return postList.stream()
                .map(PostConverter::convertPostDomainToResponse)
                .collect(Collectors.toList());
    }
}
