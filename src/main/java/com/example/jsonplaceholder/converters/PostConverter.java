package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.sup.PostResponse;
import com.example.jsonplaceholder.model.sup.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostConverter {

    public static Post convertToPost(PostRequest PostRequest) {

  
                
    }

    public static PostResponse convertToPostResponse(Post Post) {
        

    }

    public static List<PostResponse> generatePostResponseList(List<Post> PostList) {
        List<PostResponse> PostResponseList = PostList.stream()
                .map(PostConverter::convertToPostResponse)
                .collect(Collectors.toList());
        return PostResponseList;
    }
}
