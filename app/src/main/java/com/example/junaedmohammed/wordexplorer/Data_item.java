package com.example.junaedmohammed.wordexplorer;

/**
 * Created by Junaed Mohammed on 24-Jan-18.
 */

public class Data_item {

    private int id;
    private String name;

    public Data_item(String n){

        name = n;
    }

    public Data_item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id)

    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }


}
