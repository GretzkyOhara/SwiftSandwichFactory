package model;

import repo.FileOrderRepository;
import repo.OrderRepository;

import java.io.IOException;


public class OrderSystem {

    OrderRepository repo = new FileOrderRepository();

    public OrderSystem() {
    }

    public void addOrder (Order order) {
        repo.addOrder(order);

    }

    public void removeOrder(Order order) {
        repo.removeOrder(order);

    }

    public void printOrder() throws IOException {

        repo.printOrder();

    }

}
