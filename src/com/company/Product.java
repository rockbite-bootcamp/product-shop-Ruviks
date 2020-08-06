package com.company;

public class Product {
    private long ID;
    private Category category;
    private Payload payload;
    private Payload cost;
    public  Product(Payload payload,Payload cost,Category category ){
        this.payload=payload;
        this.cost=cost;
        this.category=category;
    }

    public void setID(long ID){
        this.ID=ID;
    }
    public Category getCategory(){
        return this.category;
    }
    public Payload getPayload(){
        return this.payload;
    }
    public Payload getCost(){
        return this.cost;
    }
}
