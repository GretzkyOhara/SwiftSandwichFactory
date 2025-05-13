package repo;

import model.Course;
import model.Order;
import model.Person;
import model.Sandwich;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileOrderRepository implements OrderRepository {

    public List<Order> orderList = new ArrayList<Order>();


    public FileOrderRepository() {

        if (Files.exists(Paths.get("C://temp//javacourses//orders.csv"))) {

            Stream<String> allLines = null;

            try {
                allLines = Files.lines(Paths.get("C://temp//javacourses//orders.csv"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            orderList = allLines.map(s -> this.parseOrder(s)).collect(Collectors.toList());
        }
    }

    @Override
    public void addOrder(Order order) {

        //1. check if person has more then 2 orders already
      //  int counter = 0;
    //    for (Order o : orderList) {

     //       if (o.getPerson().getName().equals(order.getPerson().getName())) {
               // counter++;
      //      }

       // }

      //  if (counter <= 2) {
            Path path = Paths.get("C://temp//javacourses//orders.csv");
            try (
                    PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
                writer.println(order.getCourse().getTitle() + "," + order.getPerson().getName() + "," + order.getSandwich().getTitle() + "," + order.getSandwich().isVegetables() + "," + order.getSandwich().isTypeOfBread());
            } catch (IOException e) {
                e.printStackTrace();
            }
       // } else {
       //     System.out.println(order.getPerson().getName() + " already ordered 2 sandwiches, not processing Order");
       // }
    }

    @Override
    public void printOrder() throws IOException {


        System.out.printf("%1$-70s\n", "Broodjes (Pinky's)");
        System.out.printf("%1$-70s\n", "");

        for (Order o : orderList) {

            System.out.printf("%1$-70s\n", "Naam:" + o.getPerson().getName());
            System.out.printf("%1$-70s\n", "Training:" + o.getCourse().getTitle());
            System.out.printf("%1$-70s\n", "");

            System.out.printf("%1$-25s%2$-25s%3$-20s\n", "Naam", "Groenten Ja/Nee", "Grijs/Wit");
            System.out.printf("%1$-25s%2$-25s%3$-20s\n", o.getSandwich().getTitle(), (o.getSandwich().isVegetables() ? "Ja" : "Nee"), (o.getSandwich().isTypeOfBread() ? "Grijs" : "Wit"));
            System.out.printf("%1$-70s\n", "");
        }


    }


    private Order parseOrder(String s) {

        Order theResult = new Order();
        String[] tokens = s.split(",");

        theResult.setCourse(new Course(tokens[0]));
        theResult.setPerson(new Person(tokens[1]));
        theResult.setSandwich(new Sandwich(tokens[2], Boolean.parseBoolean(tokens[3]), Boolean.parseBoolean(tokens[4])));

        return theResult;
    }

    private String formatOrder(Order o) {

        StringBuilder sb = new StringBuilder();

        sb.append(o.getCourse().getTitle())
                .append(",")
                .append(o.getPerson().getName())
                .append(",")
                .append(o.getSandwich().getTitle())
                .append(",")
                .append(Boolean.valueOf(o.getSandwich().isVegetables()))
                .append(",")
                .append(Boolean.valueOf(o.getSandwich().isTypeOfBread()));

        return sb.toString();
    }
}
