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
    }
}


