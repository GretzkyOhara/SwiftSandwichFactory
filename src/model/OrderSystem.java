package model;

import repo.FileOrderRepository;
import repo.OrderRepository;

import java.io.IOException;


public class OrderSystem {

    OrderRepository repo = new FileOrderRepository();

    public OrderSystem() {
    }

    public void orderSandwich(Order order) {
        repo.addOrder(order);

    }

    public void printOrder() throws IOException {

        repo.printOrder();

    }

}
