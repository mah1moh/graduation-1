package com.example.graduationproject;

public class Companies {
    private String name;
    private int img;
    public String description;
    private String adress;


    public Companies(String name, int img ) {
        this.name = name;
        this.img = img;
    }

    public Companies() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
