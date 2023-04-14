package com.example.jsonplaceholder.client;

import com.example.jsonplaceholder.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/todos")
    List<Todo> getTodos();

    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping("/photos")
    List<Photo> getPhotos();

    @GetMapping("/comments")
    List<Comment> getComments();

    @GetMapping("/albums")
    List<Album> getAlbums();


}