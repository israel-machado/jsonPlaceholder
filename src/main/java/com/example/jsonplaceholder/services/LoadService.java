package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.model.domain.*;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.placeholder.*;
import com.example.jsonplaceholder.model.placeholder.user.UserPlaceholder;
import com.example.jsonplaceholder.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.jsonplaceholder.mappers.AlbumConverter.convertAlbumPlaceholderToDomain;
import static com.example.jsonplaceholder.mappers.CommentConverter.convertCommentPlaceholderToDomain;
import static com.example.jsonplaceholder.mappers.PhotoConverter.convertPhotoPlaceholderToDomain;
import static com.example.jsonplaceholder.mappers.PostConverter.convertPostPlaceholderToDomain;
import static com.example.jsonplaceholder.mappers.TodoConverter.convertTodoPlaceholderToDomain;
import static com.example.jsonplaceholder.mappers.UserConverter.convertUserPlaceholderToDomain;

@Service
public class LoadService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    PhotoRepository photoRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    TodoRepository todoRepository;
    @Autowired
    JsonPlaceholderClient jsonPlaceholderClient;

    public void fetchAllDataFromApi() {
        List<UserPlaceholder> userPlaceholders = jsonPlaceholderClient.getUsers();
        List<UserDomain> users = new ArrayList<>();
        List<AlbumDomain> albums = new ArrayList<>();
        List<PhotoDomain> photos = new ArrayList<>();
        List<TodoDomain> todos = new ArrayList<>();
        List<PostDomain> posts = new ArrayList<>();
        List<CommentDomain> comments = new ArrayList<>();

        for (UserPlaceholder userPlaceholder : userPlaceholders) {
            UserDomain user = convertUserPlaceholderToDomain(userPlaceholder);
            users.add(user);

            List<AlbumPlaceholder> albumPlaceholders = jsonPlaceholderClient.getAlbumsByUserId(user.getId());

            for (AlbumPlaceholder albumPlaceholder : albumPlaceholders) {
                AlbumDomain album = convertAlbumPlaceholderToDomain(albumPlaceholder);
                album.setUser(user);
                albums.add(album);

                List<PhotoPlaceholder> photoPlaceholders = jsonPlaceholderClient.getPhotosByAlbumId(album.getId());

                for (PhotoPlaceholder photoPlaceholder : photoPlaceholders) {
                    PhotoDomain photo = convertPhotoPlaceholderToDomain(photoPlaceholder);
                    photo.setAlbum(album);
                    photos.add(photo);
                }
            }

            List<TodoPlaceholder> todoPlaceholders = jsonPlaceholderClient.getTodosByUserId(user.getId());

            for (TodoPlaceholder todoPlaceholder : todoPlaceholders) {
                TodoDomain todo = convertTodoPlaceholderToDomain(todoPlaceholder);
                todo.setUser(user);
                todos.add(todo);
            }

            List<PostPlaceholder> postPlaceholders = jsonPlaceholderClient.getPostsByUserId(user.getId());

            for (PostPlaceholder postPlaceholder : postPlaceholders) {
                PostDomain post = convertPostPlaceholderToDomain(postPlaceholder);
                post.setUser(user);
                posts.add(post);

                List<CommentPlaceholder> commentPlaceholders = jsonPlaceholderClient.getCommentsByPostId(post.getId());

                for (CommentPlaceholder commentPlaceholder : commentPlaceholders) {
                    CommentDomain comment = convertCommentPlaceholderToDomain(commentPlaceholder);
                    comment.setPost(post);
                    comments.add(comment);
                }
            }
        }

        userRepository.saveAll(users);
        albumRepository.saveAll(albums);
        photoRepository.saveAll(photos);
        todoRepository.saveAll(todos);
        postRepository.saveAll(posts);
        commentRepository.saveAll(comments);
    }
}
