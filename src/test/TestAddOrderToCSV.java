package test;


import controller.OrderSystem;
import model.Course;
import model.Order;
import model.Person;
import model.Sandwich;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAddOrderToCSV {

    @Test
    void CSVFileShouldContainOneExtraRowAfterAdd() {


        Path CSVFile = Paths.get("C://temp//javacourses//orders.csv");

        //1. determine current number of lines (orders) in CSV file
        long currentNumberOfOrders;

        try {
            currentNumberOfOrders = (Files.lines(CSVFile).count());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //2. submit new order
        Person p1 = new Person("Bert");
        Course c1 = new Course("Java FX");
        Sandwich sw1 = new Sandwich("Kip Curry", true, true, "Kip");

        Order order = new Order(p1, c1, sw1, "Extra mayonaise");
        OrderSystem os = new OrderSystem();
        os.addOrder(order);

        try {
            long newNumberOfOrders = (Files.lines(CSVFile).count());
            long addedNumberOfOrders = newNumberOfOrders - currentNumberOfOrders;

            assertEquals(1, addedNumberOfOrders);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
