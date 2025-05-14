package repo;

import model.Course;
import model.Order;
import model.Sandwich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

    public void addOrder(Order order);
    public void removeOrder(String personName, String sandwichName) throws IOException;
    public void printOrder() throws IOException;
    public List<Order> getOrdersByPerson(String personName);


}