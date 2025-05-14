import controller.OrderSystem;
import model.Course;
import model.Order;
import model.Person;
import model.Sandwich;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

