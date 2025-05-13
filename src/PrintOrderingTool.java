import controller.OrderSystem;

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


