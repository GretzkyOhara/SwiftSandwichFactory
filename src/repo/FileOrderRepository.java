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


    public FileOrderRepository ()  {
    }

    @Override
    public void addOrder(Order order) {

       orderList.add(order);

 //       Path path = Paths.get("C://temp//javacourses//orders.csv");
   //     try (
      //          PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
     //       writer.println(order.getCourse().getTitle() + "," + order.getPerson().getFirstName() + "," + order.getPerson().getLastName() + "," + order.getSandwich().getTitle() + "," + order.getSandwich().isVegetables() + "," + order.getSandwich().isTypeOfBread());
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }
    }


    @Override
    public void removeOrder(Order order) {
    }

    @Override
    public void printOrder() {



    }



    @Override
    public Order parseOrder(String s) {

        Order theResult = new Order();

        String[] tokens = s.split(",");

        theResult.setCourse(new Course(tokens[0]));
        theResult.setPerson(new Person(tokens[1],tokens[2]));
        theResult.setSandwich(new Sandwich(tokens[3],Integer.parseInt(tokens[4]) > 0,Integer.parseInt(tokens[5]) > 0));

        return theResult;
    }
}
