package controller;

import model.Order;
import repo.FileOrderRepository;
import repo.OrderRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/*
Class to handle incoming Orders from user interface

 */
public class OrderSystem {

    OrderRepository repo = new FileOrderRepository();

    public OrderSystem() {
    }

    /*
    method to add Order to the repo
     */
    public void addOrder (Order order) {
        repo.addOrder(order);

    }

    /*
    method to getOrders by Person

     */
    public List<Order> getOrdersByPerson(String aPersonName){

      return repo.getOrdersByPerson(aPersonName);

    }

    /*
    method to remove order from repo
     */
    public void removeOrder(String aPersonName, String aSandwichName) throws IOException {
        repo.removeOrder(aPersonName, aSandwichName);

    }

    /*
    method to print orders
     */
    public void printOrder() throws IOException {

        repo.printOrder();

    }

}
