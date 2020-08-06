package com.company;

/**
 *  User interface that contains base methods for user
 */
public interface IUser {
    //get user Id
     long getId();
     //set id
     void setId(long id);

    //get username
     String getName();
     //set username
    String setName(String username);
    //get Inventory Object
    InventoryManager getInventoryManager();

}
