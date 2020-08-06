package com.company;

import java.util.HashMap;

public class InventoryManager implements IInventory {
    HashMap<ItemType,ItemStack> inventory = new HashMap<>();
    @Override
    public void addItem(ItemType itemType, int count) throws Exception {

        if(inventory.get(itemType)==null) inventory.put(itemType, new ItemStack(itemType));
        inventory.get(itemType).add(count);
    }


    @Override
    public void removeItem(ItemType itemType, int count) throws Exception {
         ItemStack ItemStack = this.inventory.get(itemType);
        if(ItemStack==null) throw new Exception("User does not have any items of this type");
        ItemStack.remove(count);
    }

    public HashMap<ItemType, ItemStack> getInventory() {
        return inventory;
    }
    public String printInventory() {
        String result="";
        for ( ItemType type : inventory.keySet()){
            result=result + " " + type.getName() + ":" +inventory.get(type).getCount() + "\n";
        }
        return  result;
    }
}
