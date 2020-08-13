package com.company.Pool;

import com.company.Commands.BuyCommand;
import com.company.Commands.Command;
import com.company.Product;
import com.company.User;

public class CommandPool extends Pool<Command> {
    User user;
    Product product;

    @Override
    protected BuyCommand newObject() {
        return new BuyCommand(user, product);
    }

    //we can set parameters of any command in here, and we then just obtain it from pool
    public Command setBuyCommand(User user, Product product) {
        this.user = user;
        this.product = product;
        return this.obtain();

    }

}
