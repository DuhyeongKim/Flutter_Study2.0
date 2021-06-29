package com.example.yondu.ui;

public class Animal {
    private int imageid;
    public Animal(){

    }
    public Animal(int imageid, String name, String name2){
        this.imageid = imageid;
        this.name = name;
        this.name2 = name2;
    }
    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    private String  name2;
}
