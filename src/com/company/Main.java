package com.company;

import com.company.Commands.BuyCommand;
import com.company.Commands.CommandManager;
import com.company.Pool.CommandPool;

import java.util.HashMap;

public class Main {
    //i could have implemented everything a lot more wiser,but my initial code had to be refactored,i have not made
    // a single change to my initial code
    public static void main(String[] args)  {
	// write your code here
        //set up shop
        HashMap<ItemType,ItemStack> payload= new HashMap<>();
        HashMap<ItemType,ItemStack> cost= new HashMap<>();
        HashMap<ItemType,ItemStack> payload1= new HashMap<>();
        HashMap<ItemType,ItemStack> cost1= new HashMap<>();
        ItemType copper = new ItemType("copper");
        ItemType iron = new ItemType("iron");
        Category category = new Category("metals");
        payload.put(iron,new ItemStack(iron,5));
        payload1.put(iron,new ItemStack(iron,10));
        cost.put(copper,new ItemStack(copper,5));
        cost1.put(copper,new ItemStack(copper,1));
        Product product,product1;
        product = new Product(new Payload(payload),new Payload(cost),category);
        product1=new Product(new Payload(payload1),new Payload(cost1),category);
        Shop.getInstance().addProduct(product);
        Shop.getInstance().addProduct(product1);
        //create user
        User user= new User();
         user.setName("Ruben");
         System.out.println(user.getName());
         try {
            user.getInventoryManager().addItem(copper,10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
         //buys product using shopmanager
        /*try {
            product=Shop.getInstance().getProductbyID(0);
            user.getShopManager().buy(product);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        //now let us try to buy products using CommandManager
       /* CommandManager commandManager = new CommandManager();

        try {
            product=Shop.getInstance().getProductbyID(0);
            commandManager.executeCommand(new BuyCommand(user,product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        try {
            product=Shop.getInstance().getProductbyID(0);
            commandManager.executeCommand(new BuyCommand(user,product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        //UNDO
        try {
            commandManager.undo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        //REDO
        try {
            commandManager.redo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        //redoing and undoing works perfectly fine!
*/
        //now lets use the Command Pool so we do not create a new object every time we want to buy something new
        //so we will obtain commands with given parameters
        CommandPool commandPool = new CommandPool();
        CommandManager commandManager = new CommandManager();
        try {
            product=Shop.getInstance().getProductbyID(0);
            commandPool.setBuyCommand(user,product);
            commandManager.executeCommand(commandPool.obtain());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        try {
            product=Shop.getInstance().getProductbyID(0);
            commandPool.setBuyCommand(user,product);
            commandManager.executeCommand(commandPool.obtain());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
        try {
            commandManager.undo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());

        try {
            commandManager.undo();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getInventoryManager().printInventory());
    }
}
