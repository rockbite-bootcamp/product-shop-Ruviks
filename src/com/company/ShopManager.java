package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class ShopManager implements  IShopManager {
    User user;
    public ShopManager(User user){
        this.user=user;
    }

    @Override
    public void buy(Product product) throws Exception {
        if(product==null)return;
        Shop shop= Shop.getInstance();
        ArrayList<Product> shopProducts =shop.getProducts();
        if(!shopProducts.contains(product))return;
        InventoryManager inventoryManager =user.getInventoryManager();
        HashMap<ItemType,ItemStack> inventory= inventoryManager.getInventory();
        //check if user has enough resources
        HashMap<ItemType, ItemStack> cost= product.getCost().getPayload();
        HashMap<ItemType, ItemStack> payload= product.getPayload().getPayload();
        for (ItemType type : cost.keySet()){
            if(!inventory.containsKey(type))return;
            if(inventory.get(type).getCount() <cost.get(type).getCount())return;
            inventoryManager.removeItem(type,cost.get(type).getCount());
        }
        //if it did not fail now lets add payload
        for (ItemType type : payload.keySet()){
            inventoryManager.addItem(type,payload.get(type).getCount());
            //and we remove from shop
            shop.removeProduct(product);
        }

    }



    @Override
    public void buyProductbyID(int ID) throws Exception {
       Shop shop= Shop.getInstance();
       Product product =shop.getProductbyID(ID);
       if(product==null)return;
       InventoryManager inventoryManager =user.getInventoryManager();
       HashMap<ItemType,ItemStack> inventory= inventoryManager.getInventory();
        //check if user has enough resources
        HashMap<ItemType, ItemStack> cost= product.getCost().getPayload();
        HashMap<ItemType, ItemStack> payload= product.getPayload().getPayload();
        for (ItemType type : cost.keySet()){
            if(!inventory.containsKey(type))return;
            if(inventory.get(type).getCount()<cost.get(type).getCount())return;
                inventoryManager.removeItem(type,cost.get(type).getCount());
        }
        //if it did not fail now lets add payload
        for (ItemType type : payload.keySet()){
            //we add to the inventory of the user
            inventoryManager.addItem(type,payload.get(type).getCount());
            //and we remove from shop
            shop.removeProduct(product);
        }

    }
}
