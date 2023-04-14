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
        List<Post> PostList = repository.findAll();
        return generatePostResponseList(PostList);
    }

    public PostResponse findById(Long id) {
        Optional<Post> Post = repository.findById(id);
        return Post.map(PostConverter::convertToPostResponse).orElse(null);
    }

    public PostResponse insert(PostRequest PostRequest) {
        Post Post = convertToPost(PostRequest);
        Post = repository.save(Post);
        return convertToPostResponse(Post);
    }

    public PostResponse update(Long id, PostRequest PostRequest) {
        Post Post = convertToPost(PostRequest);
        Post.setId(id);
        Post updatedPost = repository.save(Post);
        return convertToPostResponse(Post);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
