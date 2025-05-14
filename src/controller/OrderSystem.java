package controller;

import model.Order;
import repo.FileOrderRepository;
import repo.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class OrderSystem {

    OrderRepository repo = new FileOrderRepository();

    public OrderSystem() {
    }

    public void addOrder (Order order) {
        repo.addOrder(order);

    }

    public List<Order> getOrdersByPerson(String aPersonName){

      return repo.getOrdersByPerson(aPersonName);

    }

    public void removeOrder(String aPersonName, String aSandwichName) throws IOException {
        repo.removeOrder(aPersonName, aSandwichName);

    }

    public void printOrder() throws IOException {

        repo.printOrder();

    }

}
