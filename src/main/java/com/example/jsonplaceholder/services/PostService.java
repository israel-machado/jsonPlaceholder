package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.mappers.PostConverter;
import com.example.jsonplaceholder.model.domain.PostDomain;
import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.PostResponse;
import com.example.jsonplaceholder.model.placeholder.PostPlaceholder;
import com.example.jsonplaceholder.repository.PostRepository;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.PostConverter.*;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    private UserRepository userRepository;
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<PostResponse> findAll() {
        List<PostDomain> postList = repository.findAll();
        return generatePostResponseList(postList);
    }

    public PostResponse findById(Long id) {
        Optional<PostDomain> post = repository.findById(id);
        return post.map(PostConverter::convertToPostResponse).orElse(null);
    }

    public PostResponse insert(PostRequest postRequest) {
        PostDomain post = convertRequestToDomain(postRequest);
        post = repository.save(post);
        return convertToPostResponse(post);
    }

    public PostResponse update(Long id, PostRequest postRequest) {
        PostDomain post = convertRequestToDomain(postRequest);
        post.setId(id);
        PostDomain updatedPost = repository.save(post);
        return convertToPostResponse(updatedPost);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void savePostsFromApi() {
        List<PostPlaceholder> postsPlaceholder = jsonPlaceholderClient.getPosts();
        for (PostPlaceholder post : postsPlaceholder) {
            PostDomain postDomain = convertPlaceholderToDomain(post);
            repository.save(postDomain);
        }
    }
}
