package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.model.domain.CommentDomain;
import com.example.jsonplaceholder.model.placeholder.CommentPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    // Domain

    public static CommentDomain convertRequestToDomain(CommentRequest commentRequest) {
        return CommentDomain.builder()
                .id(commentRequest.getId())
                .postId(commentRequest.getPostId())
                .name(commentRequest.getName())
                .body(commentRequest.getBody())
                .email(commentRequest.getEmail())
                .build();
    }

    public static CommentDomain convertPlaceholderToDomain(CommentPlaceholder commentPlaceholder) {
        return CommentDomain.builder()
                .id(commentPlaceholder.getId())
                .postId(commentPlaceholder.getPostId())
                .name(commentPlaceholder.getName())
                .body(commentPlaceholder.getBody())
                .email(commentPlaceholder.getEmail())
                .build();
    }

    // Response

    public static CommentResponse convertToCommentResponse(CommentDomain comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPostId())
                .name(comment.getName())
                .body(comment.getBody())
                .email(comment.getEmail())
                .build();

    }

    public static List<CommentResponse> generateCommentResponseList(List<CommentDomain> commentList) {
        return commentList.stream()
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
    }
}
