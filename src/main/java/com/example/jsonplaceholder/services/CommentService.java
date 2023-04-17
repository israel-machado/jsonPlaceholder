package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.CommentConverter;
import com.example.jsonplaceholder.model.domain.CommentDomain;
import com.example.jsonplaceholder.model.domain.PostDomain;
import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.repository.CommentRepository;
import com.example.jsonplaceholder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.CommentConverter.*;

@Service
public class CommentService {

    @Autowired
    private CommentRepository repository;

    private PostRepository postRepository;
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<CommentResponse> findAll() {
        List<CommentDomain> commentList = repository.findAll();
        return generateCommentResponseList(commentList);
    }

    public CommentResponse findById(Long id) {
        Optional<CommentDomain> comment = repository.findById(id);
        return comment.map(CommentConverter::convertToCommentResponse).orElse(null);
    }

    public CommentResponse insert(CommentRequest commentRequest) {
        CommentDomain comment = convertToComment(commentRequest);
        comment = repository.save(comment);
        return convertToCommentResponse(comment);
    }

    public CommentResponse update(Long id, CommentRequest commentRequest) {
        CommentDomain comment = convertToComment(commentRequest);
        comment.setId(id);
        CommentDomain updatedComment = repository.save(comment);
        return convertToCommentResponse(updatedComment);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void saveCommentsFromApi() {
        List<CommentDomain> comments = jsonPlaceholderClient.getComments();
        for (CommentDomain comment : comments) {
            if (comment != null) {
                PostDomain post = postRepository.findById(comment.getPostId()).orElse(null);
                if (post != null) {
                    comment.setPostId(post.getId());
                }
                repository.save(comment);
            }
        }
    }
}
