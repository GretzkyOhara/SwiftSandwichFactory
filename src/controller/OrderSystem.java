package controller;

import model.Order;
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

    public void removeOrder(String aPersonName, String aSandwichName) throws IOException {
        repo.removeOrder(aPersonName, aSandwichName);

    }

    public void printOrder() throws IOException {

        repo.printOrder();

    }

}
