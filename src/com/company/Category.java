package com.company;

public class Category {
    //I have made a Category class,to abstract the meaning of category,as
    //it might contain more than one "category" for example
    //but in this case i will just use one category name
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
