package com.company;

import java.util.HashMap;

public class Payload {
    HashMap<ItemType, ItemStack> payload = new HashMap<>();

    public Payload(HashMap<ItemType, ItemStack> payload) {
        this.payload = payload;
    }

    public Payload() {

    }

    public HashMap<ItemType, ItemStack> getPayload() {
        return payload;
    }
}
