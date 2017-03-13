package com.codekul.jsonparsing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aniruddha on 13/3/17.
 */

public class Example {
    private String name;
    private Tut tut;
    private List<String> langs = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tut getTut() {
        return tut;
    }

    public void setTut(Tut tut) {
        this.tut = tut;
    }

    public List<String> getLangs() {
        return langs;
    }

    public void setLangs(List<String> langs) {
        this.langs = langs;
    }
}
