package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.model.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    public static Comment convertToComment(CommentRequest commentRequest) {
        return Comment.builder()
                .id(commentRequest.getId())
                .postId(commentRequest.getPostId())
                .name(commentRequest.getName())
                .body(commentRequest.getBody())
                .email(commentRequest.getEmail())
                .build();
    }

    public static CommentResponse convertToCommentResponse(Comment comment) {
        return CommentResponse.builder()
                .id(comment.getId())
                .postId(comment.getPostId())
                .name(comment.getName())
                .body(comment.getBody())
                .email(comment.getEmail())
                .build();

    }

    public static List<CommentResponse> generateCommentResponseList(List<Comment> commentList) {
        return commentList.stream()
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
    }
}
