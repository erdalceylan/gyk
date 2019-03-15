package com.example.gyk;

public class Newspaper {
    private String img;
    private String text;
    private String url;

    public Newspaper(String img, String text, String url){
        this.img = img;
        this.text = text;
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
