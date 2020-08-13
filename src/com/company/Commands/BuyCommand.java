package com.company.Commands;

import com.company.Product;
import com.company.User;

public class BuyCommand implements Command {
    User user;
    Product product;

    public BuyCommand(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    @Override
    public void execute() throws Exception {
        user.getShopManager().buy(product);
    }

    @Override
    public void undo() throws Exception {
        user.getShopManager().returnProduct(product);
    }

    @Override
    public void reset() {
        this.user = null;
        this.product = null;

    }
}
