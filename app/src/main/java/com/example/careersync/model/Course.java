package com.example.careersync.model;

public class Course {
    private String courseName;
    private String rating;
    private String type;
    private  String price;
    public Course(){}

    public Course(String courseName, String rating, String type, String price) {
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
