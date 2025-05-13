//https://github.com/GretzkyOhara/SwiftSandwichFactory

package test;

import model.*;
import org.apache.commons.lang3.StringUtils;
import repo.CourseRepository;
import repo.FileCourseRepository;
import repo.FileSandwichRepository;
import repo.SandwichRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class GUI_Test {

        public static void main(String[] args) throws IOException {

            CourseRepository cr = null;
            cr = new FileCourseRepository();

           // System.out.println("----------------- LOADING COURSES ---------------");
            Path filePath = Paths.get("/temp/javacourses/courses.csv");
            try {
                // Read all lines into a List
                List<String> lines = Files.readAllLines(filePath);
                // Parse and add to courses
                for (String s1 : lines){
                    String[] vals = s1.split(";");
                    String t1 = vals[0];
                    Course c1 = new Course(t1);
                    cr.addCourse(c1);

                   // System.out.println(t1);
                }
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }

            //SandwichRepository sr = null;
            FileSandwichRepository sr = new FileSandwichRepository();
            Integer cnt = 0;



            Scanner scanner = new Scanner(System.in);
            System.out.print("Name : ");
            String aName = scanner.nextLine();
            //System.out.println(aName);
            System.out.print("Course : ");
            String aCourseName = scanner.nextLine();

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("        ENTER THE NR CORRESPONDING TO THE SANDWICH");
            System.out.println("-----------------------------------------------------------");

            Path filePath2 = Paths.get("/temp/javacourses/sandwiches.csv");
            try {
                // Read all lines into a List
                List<String> lines2 = Files.readAllLines(filePath2);
                // Parse and add to courses
                for (String s2 : lines2){
                    cnt++;
                    String[] vals2 = s2.split(";");
                    String t2 = (vals2[0]);
                    Boolean b1 = Integer.parseInt(vals2[1]) >0;

                    Sandwich c2 = new Sandwich(cnt,t2,b1,false);
                    sr.addSandwich(c2);

                    System.out.println(cnt.toString() + ". " + t2);
                }
            } catch (Exception e) {
                // Handle exceptions
                e.printStackTrace();
                System.err.println("An error occurred while reading the file: " + e.getMessage());
            }

            System.out.print("Nr : ");
            String nr = scanner.nextLine();
            Integer nrSelected = 0;
            String nameSelected = "";
            Boolean extraVeggies = false;
            Integer breadSelected = 0;
            Boolean breadType  = false;


            // check if nr exists and if you can add veggies
            if (StringUtils.isNumeric(nr)) {
                nrSelected = Integer.parseInt(nr);
                for (Sandwich s : sr.getSandwiches()) {
                    if (nrSelected == s.getNum()){
                        nameSelected = s.getTitle();
                        //System.out.println("FOUND " + s.getTitle());
                        if (s.isVegetables() == true) {
                            System.out.print("Would you like vegetables with your sandwich? (Y/N) : ");
                            String resYN = scanner.nextLine();
                            if(resYN.toUpperCase() == "Y"){
                                extraVeggies = true;
                            }
                        }
                        System.out.println("Which type of bread would you like? : ");
                        System.out.println("     1 - White");
                        System.out.println("     2 - Grey");
                        String breadTypeSelected = scanner.nextLine();
                        if (StringUtils.isNumeric(breadTypeSelected)) {
                            breadSelected =Integer.parseInt(breadTypeSelected);
                            breadType = (breadSelected >1);

                            System.out.println("PASS THE ORDER TO BERT");


                            Person p1 = new Person(aName);
                            Course c1 = new Course(aCourseName);
                            Sandwich sw1 = new Sandwich(nameSelected, extraVeggies, breadType);

                            Order order = new Order(p1, c1, sw1);

                            OrderSystem os = new OrderSystem();
                            os.orderSandwich(order);




                        }


                    }
                }
            }
            else{
                System.out.println("ERROR");
            }




        }
}
