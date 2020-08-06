package com.company;

public class ItemType {
    private  String name;
    private  String description="";
    public ItemType(String name){
        this.name=name;
    }
    public ItemType(String name,String description){
        this.name=name;
        this.description=description;
    }
    public String getName(){
        return this.name;
    }
}
