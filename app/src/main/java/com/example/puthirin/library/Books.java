package com.example.puthirin.library;

/**
 * Created by Puthirin on 11/7/2017.
 */

class Books {
    private int imageId;
    private String title;
    private String author;
    private String category;
    private String year;


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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Books(int imageId, String title, String category, String author, String year) {
        this.imageId = imageId;
        this.title = title;
        this.author = author;
        this.year = year;
        this.category = category;
    }



}
