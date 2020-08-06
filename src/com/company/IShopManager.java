package com.company;

public interface IShopManager {
    void buy(Product product) throws Exception;
    void buyProductbyID(int ID) throws Exception;

}
