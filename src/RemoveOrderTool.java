import controller.OrderSystem;
import model.Order;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class RemoveOrderTool {

    public static void main(String[] args) {


        Integer cnt = 0;
        OrderSystem orderSystem = new OrderSystem();

        List<Order> foundItems ;


                Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        String input_PersonName = scanner.nextLine();

        foundItems =  orderSystem.getOrdersByPerson(input_PersonName);

        for (Order o : foundItems) {
            cnt++;
            System.out.println(cnt + ". " + o.getPerson().getName());
        }

//        System.out.print("Sandwich name : ");
//        String input_SandwichName = scanner.nextLine();
//        try {
//            orderSystem.removeOrder(input_PersonName, input_SandwichName);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }


    }


}

