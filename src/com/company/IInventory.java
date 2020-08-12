package com.company;

public interface IInventory {
    void addItem(ItemType itemType, int count) throws Exception;

    void removeItem(ItemType itemType, int count) throws Exception;

}
