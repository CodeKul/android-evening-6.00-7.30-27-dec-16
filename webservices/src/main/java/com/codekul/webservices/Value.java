package com.codekul.webservices;

import java.util.ArrayList;

/**
 * Created by aniruddha on 13/3/17.
 */

public class Value {

    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String joke;

    public String getJoke() {
        return this.joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    private ArrayList<Object> categories;

    public ArrayList<Object> getCategories() {
        return this.categories;
    }

    public void setCategories(ArrayList<Object> categories) {
        this.categories = categories;
    }
}
