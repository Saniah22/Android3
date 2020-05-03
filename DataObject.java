package com.example.android3;

public class DataObject {
    private String txt_title;
    private String txt_author;
    private String txt_level;
    private String txt_info;
    private String txt_URL;
    private String img_id;

    public DataObject(String txt_title,String txt_author,String txt_level,String txt_info,String img_id, String txt_URL){
        this.txt_title = txt_title;
        this.txt_author = txt_author;
        this.txt_level = txt_level;
        this.txt_info = txt_info;
        this.txt_image = txt_image;
        this.txt_URL = txt_URL;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }

    public String getLevel() {
        return level;
    }

    public String getInfo() {
        return info;
    }

    public String getURL() {
        return URL;
    }

    public String getImage() {
        return image;
    }
}
