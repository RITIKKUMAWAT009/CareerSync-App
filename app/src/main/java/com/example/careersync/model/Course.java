package com.example.careersync.model;

public class Course {
    private String courseName;
    private Integer rating;
    private String type;
    private  Integer price;
    public Course(){}

    public Course(String courseName, Integer rating, String type, Integer price) {
        this.courseName = courseName;
        this.rating = rating;
        this.type = type;
        this.price = price;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
