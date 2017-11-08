package com.example.puthirin.library;

/**
 * Created by Puthirin on 11/7/2017.
 */

class Books {
    private int imageId;
    private String title;
    private String author;
    private String description;

    public Books(int imageId, String title, String description) {
        this.imageId = imageId;
        this.title = title;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Books(int imageId, String title, String author, String description) {
        this.imageId = imageId;
        this.title = title;

        this.author = author;
        this.description = description;
    }
}
