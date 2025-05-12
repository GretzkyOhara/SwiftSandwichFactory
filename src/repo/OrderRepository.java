package repo;

import model.Course;
import model.Order;
import model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepository {

    public void addOrder();
    public void removeOrder() ;

    public void addSandwichToOrder(Course course, Sandwich sandwich) ;
    public void removeSandwichFromOrder(Course course, Sandwich sandwich) ;

    public void printOrder() ;


}