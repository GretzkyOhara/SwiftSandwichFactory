import controller.OrderSystem;
import model.Course;
import model.Order;
import model.Person;
import model.Sandwich;

import java.io.IOException;

public class PrintOrderingTool {

    public static void main(String[] args) {

        OrderSystem orderSystem = new OrderSystem();

        try {
            orderSystem.printOrder();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Person p1 = new Person("Jacob");
        Course c1 = new Course("test");

        Sandwich sw1 = new Sandwich("kip curry", false, false,"Vis");
        Order order = new Order(p1, c1, sw1);

    }
}


