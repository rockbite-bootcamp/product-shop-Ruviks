package com.company.Pool;

import com.company.*;
import com.company.Commands.BuyCommand;
import com.company.Commands.Command;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CommandPoolTest {

    @Test
    void newObject() {
    }

    @Test
    @DisplayName("Checks if obtain works correctly")
    void obtain() {
        CommandPool commandPool = new CommandPool();
        User user = new User();
        User user1 = new User();
        HashMap<ItemType, ItemStack> payload = new HashMap<>();
        HashMap<ItemType, ItemStack> cost = new HashMap<>();
        ItemType copper = new ItemType("copper");
        ItemType iron = new ItemType("iron");
        Category category = new Category("metals");
        payload.put(iron, new ItemStack(iron, 5));
        cost.put(copper, new ItemStack(copper, 5));
        Product product;
        product = new Product(new Payload(payload), new Payload(cost), category);

        user.setName("Ruben");
        user1.setName("Ruvik");
        commandPool.setBuyCommand(user, product);
        Command result = commandPool.obtain();
        commandPool.free(result);
        assertEquals(true, result.equals(commandPool.obtain()));
        commandPool.setBuyCommand(user1, product);
        result = commandPool.obtain();
        commandPool.free(result);
        assertEquals(true, result.equals(commandPool.obtain()));


    }
}