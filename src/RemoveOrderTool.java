import controller.OrderSystem;

import java.io.IOException;
import java.util.Scanner;

public class RemoveOrderTool {

    public static void main(String[] args) {

        OrderSystem orderSystem = new OrderSystem();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        String input_PersonName = scanner.nextLine();
        System.out.print("Sandwich name : ");
        String input_SandwichName = scanner.nextLine();
        try {
            orderSystem.removeOrder(input_PersonName, input_SandwichName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

