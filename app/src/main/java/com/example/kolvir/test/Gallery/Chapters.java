package com.example.kolvir.test.Gallery;

import com.example.kolvir.test.R;

import java.util.ArrayList;
import java.util.List;


public class Chapters {
    private String Name;
    private Integer Image;

    public Chapters(String name, Integer id){
        Name = name;
        Image = id;

    }

    public Integer getImage() {
        return Image;
    }

    public void setImage(Integer image) {
        this.Image = image;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public static List<Chapters> getChapters(){
        ArrayList<Chapters> items = new ArrayList<>();

        items.add(new Chapters("Chapter1", R.drawable.forfirst1));
        items.add(new Chapters("Chapter2", R.drawable.forsecond1));
        items.add(new Chapters("Chapter3", R.drawable.test1));

        return items;
    }
}
