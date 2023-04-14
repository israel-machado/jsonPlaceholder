package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.PostConverter;
import com.example.jsonplaceholder.model.Post;
import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.PostResponse;
import com.example.jsonplaceholder.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.PostConverter.*;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<PostResponse> findAll() {
        List<Post> postList = repository.findAll();
        return generatePostResponseList(postList);
    }

    public PostResponse findById(Long id) {
        Optional<Post> post = repository.findById(id);
        return post.map(PostConverter::convertToPostResponse).orElse(null);
    }

    public PostResponse insert(PostRequest postRequest) {
        Post post = convertToPost(postRequest);
        post = repository.save(post);
        return convertToPostResponse(post);
    }

    public PostResponse update(Long id, PostRequest postRequest) {
        Post post = convertToPost(postRequest);
        post.setId(id);
        Post updatedPost = repository.save(post);
        return convertToPostResponse(updatedPost);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
