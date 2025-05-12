package model;

import repo.FileOrderRepository;
import repo.OrderRepository;


public class OfficeManager extends Person {

    OrderRepository repo = new FileOrderRepository();

    public OfficeManager(String firstName, String lastName) {

        super (firstName,lastName);
    }

    public void createOrder() {
           }

    public void removeOrder() {

    }

    public void addSandwichToOrder(Course course, Sandwich sandwich) {

    }

    public void removeSandwichFromOrder(Course course, Sandwich sandwich) {

    }

    public void printOrder() {}



}
