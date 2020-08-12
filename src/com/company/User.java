package com.company;

public class User implements IUser {
    private long id;
    private String name;
    private InventoryManager inventoryManager = new InventoryManager();
    private int cash;
    private int buyCount = 0;
    private ShopManager shopManager;

    public User() {
        shopManager = new ShopManager(this);
    }

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String setName(String username) {
        this.name = username;
        return this.name;
    }

    public int getCash() {
        return this.cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }


    @Override
    public InventoryManager getInventoryManager() {
        return this.inventoryManager;
    }

    public ShopManager getShopManager() {
        return this.shopManager;
    }

    public int getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(int buyCount) {
        this.buyCount = buyCount;
    }

    public void incrementBuyCount() {
        this.buyCount++;
    }
}
