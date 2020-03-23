package com.example.graduationproject;

import java.util.ArrayList;

public class Offers {
    String name,balad,contryname;
    ArrayList include;
    ArrayList not_include;
    int img,id;
    int time,rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContryname() {
        return contryname;
    }

    public void setContryname(String contryname) {
        this.contryname = contryname;
    }

    public Offers(String name, String balad, String contryname, int img, int time, int rating) {
        this.name = name;
        this.balad = balad;
        this.img = img;
        this.time = time;
        this.rating = rating;
        this.contryname=contryname;
    }

    public String getBalad() {
        return balad;
    }

    public void setBalad(String balad) {
        this.balad = balad;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Offers(String name, int img, int id) {
        this.id=id;
        this.name = name;
        this.img = img;
    }

    public Offers(ArrayList include, ArrayList not_include) {
        this.include = include;
        this.not_include = not_include;
    }

    public Offers(String name, ArrayList include, ArrayList not_include, int img) {
        this.name = name;
        this.include = include;
        this.not_include = not_include;
        this.img = img;
    }

    public Offers() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList getInclude() {
        return include;
    }

    public void setInclude(ArrayList include) {
        this.include = include;
    }

    public ArrayList getNot_include() {
        return not_include;
    }

    public void setNot_include(ArrayList not_include) {
        this.not_include = not_include;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
