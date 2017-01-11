package com.codekul.listview;

/**
 * Created by aniruddha on 11/1/17.
 */

public class MyItem {

    private int imageId;
    private String text;

    public MyItem(int imageId, String text) {
        this.imageId = imageId;
        this.text = text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
