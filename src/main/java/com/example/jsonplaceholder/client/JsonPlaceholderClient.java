package com.example.jsonplaceholder.client;

import com.example.jsonplaceholder.model.placeholder.*;
import com.example.jsonplaceholder.model.placeholder.user.AddressPlaceholder;
import com.example.jsonplaceholder.model.placeholder.user.CompanyPlaceholder;
import com.example.jsonplaceholder.model.placeholder.user.GeoPlaceholder;
import com.example.jsonplaceholder.model.placeholder.user.UserPlaceholder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "jsonplaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceholderClient {

    @GetMapping("/users")
    List<UserPlaceholder> getUsers();

    @GetMapping("/todos")
    List<TodoPlaceholder> getTodos();

    @GetMapping("/posts")
    List<PostPlaceholder> getPosts();

    @GetMapping("/photos")
    List<PhotoPlaceholder> getPhotos();

    @GetMapping("/comments")
    List<CommentPlaceholder> getComments();

    @GetMapping("/albums")
    List<AlbumPlaceholder> getAlbums();

    @GetMapping("/addresses")
    List<AddressPlaceholder> getAddresses();

    @GetMapping("/companies")
    List<CompanyPlaceholder> getCompanies();

    @GetMapping("/geos")
    List<GeoPlaceholder> getGeos();
}
