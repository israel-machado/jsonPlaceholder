package com.example.jsonplaceholder.model.dto.response;

public class AlbumResponse {

    private Long id;
    private Long userId;
    private String title;

    public AlbumResponse() {
    }

    public AlbumResponse(Long id, Long userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
