import model.*;

import java.io.IOException;

public class SandWichOrderingTool {

    public static void main (String [] args) {

        OrderSystem orderSystem = new OrderSystem();

        Person p1 = new Person ("John", "Doe");
        Course c1 = new Course("Java");
        Sandwich sw1 = new Sandwich("Hesp",false,false);

        Order order = new Order(p1,c1,sw1);
        orderSystem.orderSandwich(order);
    }
}
