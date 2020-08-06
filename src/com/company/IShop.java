package com.company;

import java.util.ArrayList;

public interface IShop {
    void addProduct(Product product);
    void removeProduct(Product product);
    Product getProductbyID(long ID);
    ArrayList<Product> getProducts();
    ArrayList<Product> getProductsbyCategory(Category category);
}
