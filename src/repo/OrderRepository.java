package repo;

import model.Course;
import model.Order;
import model.Sandwich;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

    public void addOrder(Order order);
    public void removeOrder(Order order) ;
    public void printOrder() throws IOException;
    public Order parseOrder(String s);


}