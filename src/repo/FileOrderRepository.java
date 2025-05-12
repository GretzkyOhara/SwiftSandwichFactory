package repo;

import model.Course;
import model.Order;
import model.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {

    public List<Order> orderList = new ArrayList<Order>();


    @Override
    public void addOrder() {

    }

    @Override
    public void removeOrder() {

    }

    @Override
    public void addSandwichToOrder(Course course, Sandwich sandwich) {

    }

    @Override
    public void removeSandwichFromOrder(Course course, Sandwich sandwich) {

    }

    @Override
    public void printOrder() {

    }
}
