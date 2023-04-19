package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.PostDomain;
import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.model.domain.CommentDomain;
import com.example.jsonplaceholder.model.placeholder.CommentPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    // Domain

    public static CommentDomain convertCommentRequestToDomain(CommentRequest commentRequest) {
        return CommentDomain.builder()
                .id(commentRequest.getId())
                .name(commentRequest.getName())
                .body(commentRequest.getBody())
                .email(commentRequest.getEmail())
                .build();
    }

    public static CommentDomain convertCommentPlaceholderToDomain(CommentPlaceholder commentPlaceholder) {
        return CommentDomain.builder()
                .id(commentPlaceholder.getId())
                .name(commentPlaceholder.getName())
                .body(commentPlaceholder.getBody())
                .email(commentPlaceholder.getEmail())
                .build();
    }

    // Response

    public static CommentResponse convertCommentDomainToResponse(CommentDomain comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .name(comment.getName())
                .body(comment.getBody())
                .email(comment.getEmail())
                .build();

    }

    public static List<CommentResponse> generateCommentDomainListToCommentResponseList(List<CommentDomain> commentList) {
        return commentList.stream()
                .map(CommentConverter::convertCommentDomainToResponse)
                .collect(Collectors.toList());
    }
}
