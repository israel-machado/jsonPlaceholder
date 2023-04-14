package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.sup.CommentResponse;
import com.example.jsonplaceholder.model.sup.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentConverter {

    public static Comment convertToComment(CommentRequest CommentRequest) {

  
                
    }

    public static CommentResponse convertToCommentResponse(Comment Comment) {
        

    }

    public static List<CommentResponse> generateCommentResponseList(List<Comment> CommentList) {
        List<CommentResponse> CommentResponseList = CommentList.stream()
                .map(CommentConverter::convertToCommentResponse)
                .collect(Collectors.toList());
        return CommentResponseList;
    }
}
