package com.andreakim.sequels;

/**
 * Created by andreakim on 6/22/16.
 */
public class Sequel {
    public int id;
    public String name;

    public Sequel( int id, String name) {
        this.name = name;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
