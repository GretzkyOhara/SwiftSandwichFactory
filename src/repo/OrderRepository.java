package repo;

import model.Course;
import model.Order;
import model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

    public List <Order> orderList = new ArrayList<Order>();

    void printOrder(Order order);
    void addOrder();
    void removeOrder();

}