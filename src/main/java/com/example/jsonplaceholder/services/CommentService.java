package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.CommentConverter;
import com.example.jsonplaceholder.model.Comment;
import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.CommentConverter.*;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    public List<CommentResponse> findAll() {
        List<Comment> CommentList = repository.findAll();
        return generateCommentResponseList(CommentList);
    }

    public CommentResponse findById(Long id) {
        Optional<Comment> Comment = repository.findById(id);
        return Comment.map(CommentConverter::convertToCommentResponse).orElse(null);
    }

    public CommentResponse insert(CommentRequest CommentRequest) {
        Comment Comment = convertToComment(CommentRequest);
        Comment = repository.save(Comment);
        return convertToCommentResponse(Comment);
    }

    public CommentResponse update(Long id, CommentRequest CommentRequest) {
        Comment Comment = convertToComment(CommentRequest);
        Comment.setId(id);
        Comment updatedComment = repository.save(Comment);
        return convertToCommentResponse(Comment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
