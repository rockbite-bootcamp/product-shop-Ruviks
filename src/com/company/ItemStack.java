package com.company;

public class ItemStack {
    private int count;
    private ItemType itemType;

    public ItemStack(ItemType itemType) {
        this.itemType = itemType;
        count = 0;
    }

    public ItemStack(ItemType itemType, int count) {
        this.itemType = itemType;
        this.count = count;
    }

    public void add(int count) throws Exception {
        if (count <= 0) throw new Exception("Count shall be greater than zero");
        this.count += count;

    }

    public void remove(int count) throws Exception {
        if (count <= 0) throw new Exception("Count shall be greater than zero");
        this.count -= count;
    }

    public int getCount() {
        return this.count;
    }
}
