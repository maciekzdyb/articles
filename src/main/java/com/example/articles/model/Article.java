package com.example.articles.model;

import lombok.Data;

import java.util.List;

@Data
public class Article {

    private Long id;
    private boolean featured;
    private String title;
    private String url;
    private String imageUrl;
    private String newsSite;
    private String summary;
    private String publishedAt;
    private String updatedAt;
    private List<Event> launches;
    private List<Event> events;

}
