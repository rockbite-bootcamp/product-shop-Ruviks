package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //set up shop
        HashMap<ItemType,ItemStack> payload= new HashMap<>();
        HashMap<ItemType,ItemStack> cost= new HashMap<>();
        ItemType copper = new ItemType("copper");
        ItemType iron = new ItemType("iron");
        Category category = new Category("metals");
        payload.put(iron,new ItemStack(iron,5));
        cost.put(copper,new ItemStack(copper,5));
        Product product;
        product = new Product(new Payload(payload),new Payload(cost),category);
        Shop.getInstance().addProduct(product);

        User user= new User();
         user.setName("Ruben");
         System.out.println(user.getName());

        try {
            user.getInventoryManager().addItem(copper,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        try {
            product=Shop.getInstance().getProductbyID(0);
            user.getShopManager().buy(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());

    }
}
