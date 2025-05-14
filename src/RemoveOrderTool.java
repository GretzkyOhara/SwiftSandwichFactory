import controller.OrderSystem;
import model.Order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RemoveOrderTool {

    public static void main(String[] args) {

        OrderSystem orderSystem = new OrderSystem();
        List<Order> theResult = new ArrayList<Order>();
        Integer cnt = 0;
        Integer selectedItem = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        String input_PersonName = scanner.nextLine();

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("        Select the number corresponding to the sandwich you want to remove");
        System.out.println("-------------------------------------------------------------------------------------");


        theResult = orderSystem.getOrdersByPerson(input_PersonName);
        for (Order o : theResult) {
            cnt++;
            System.out.printf("%1$-4s%2$-30s%3$-25s\n", cnt + ".", o.getPerson().getName(), o.getSandwich().getTitle());
        }

        cnt = 0;
        System.out.print("Number : ");
        String nr = scanner.nextLine();

        for (Order o : theResult) {
            cnt++;
            if (cnt.toString().equals(nr)){
                try {
                    orderSystem.removeOrder(o.getPerson().getName(), o.getSandwich().getTitle());
                    System.out.println("Order removed!");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }




    }


}

