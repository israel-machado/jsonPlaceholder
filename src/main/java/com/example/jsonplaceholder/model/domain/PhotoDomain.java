package com.example.jsonplaceholder.model.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "photo")
public class PhotoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private AlbumDomain album;
}
