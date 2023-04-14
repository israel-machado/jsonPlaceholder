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
        List<Comment> commentList = repository.findAll();
        return generateCommentResponseList(commentList);
    }

    public CommentResponse findById(Long id) {
        Optional<Comment> comment = repository.findById(id);
        return comment.map(CommentConverter::convertToCommentResponse).orElse(null);
    }

    public CommentResponse insert(CommentRequest commentRequest) {
        Comment comment = convertToComment(commentRequest);
        comment = repository.save(comment);
        return convertToCommentResponse(comment);
    }

    public CommentResponse update(Long id, CommentRequest commentRequest) {
        Comment comment = convertToComment(commentRequest);
        comment.setId(id);
        Comment updatedComment = repository.save(comment);
        return convertToCommentResponse(updatedComment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
