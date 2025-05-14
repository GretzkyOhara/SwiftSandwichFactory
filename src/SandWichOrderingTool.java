import controller.OrderSystem;
import model.*;
import org.apache.commons.lang3.StringUtils;
import repo.CourseRepository;
import repo.FileCourseRepository;
import repo.FileSandwichRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
////https://github.com/GretzkyOhara/SwiftSandwichFactory

public class SandWichOrderingTool {

    public static void main(String[] args) {



        // System.out.println("----------------- LOADING COURSES ---------------");
        Path filePath = Paths.get("/temp/javacourses/courses.csv");

        try {

            CourseRepository cr = null;
            cr = new FileCourseRepository();

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

        System.out.println("Kies de Taal / Choisisez la Langue");
        System.out.println("     1 - Nederlands");
        System.out.println("     2 - Français");
        String resLanguage = scanner.nextLine();

        Boolean bResLanguage = (resLanguage.equals("1")) ? true : false;


        System.out.print((bResLanguage ? "Naam" : "Nom")+ " : ");
        String aName = scanner.nextLine();
        //System.out.println(aName);
        System.out.print((bResLanguage ? "Cursus" : "Cours")+ " : ");
        String aCourseName = scanner.nextLine();



        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("        " + (bResLanguage ? "Kies het overeenstemmende nummer voor de sandwich" : "Choisisez le numéro qui corresponds au sandwich"  + " : "));
        System.out.println("-------------------------------------------------------------------------------------");

        Path filePath2 = Paths.get("/temp/javacourses/" + (bResLanguage ? "sandwiches.csv" : "sandwiches_FR.csv" ));
        try {
            // Read all lines into a List
            List<String> lines2 = Files.readAllLines(filePath2);
            // Parse and add to courses
            for (String s2 : lines2){
                cnt++;
                String[] vals2 = s2.split(";");
                String t2 = vals2[0];
                Boolean b1 = Integer.parseInt(vals2[1]) >0;
                String sT = vals2[2];
                Sandwich c2 = new Sandwich( cnt,t2,b1,false,sT);
                sr.addSandwich(c2);

                System.out.println(cnt.toString() + ". " + t2);
            }
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            System.err.println((bResLanguage ? "!!! Er is een fout opgetreden !!!" : "!!! Une erreur c'est produite !!!") + e.getMessage());
        }

        System.out.print((bResLanguage ? "Nummer : " : "Numéro")+ " : ");
        String nr = scanner.nextLine();
        Boolean extraVeggies = false;
        Integer breadSelected = 0;
        Boolean breadType  = false;
        String resYN = "";
        String orderComments = "";

        // check if nr exists and if you can add veggies
        if (StringUtils.isNumeric(nr)) {
            Integer nrSelected = Integer.parseInt(nr);
            for (Sandwich s : sr.getSandwiches()) {
                if (nrSelected == s.getNum()){
                    String nameSelected = s.getTitle();
                    String sType = s.getSandwichType();
                    //System.out.println("FOUND " + s.getTitle());
                    if (s.isVegetables() == true) {
                        //System.out.print("Would you like vegetables with your sandwich? (Y/N) : ");
                        System.out.print((bResLanguage ? "Wenst u goeten bij uw sandwich? (J/N)" : "Desirez vous des crudités avec votre sandwich? (O/N)")+ " : ");
                        resYN = scanner.nextLine();
                        if(resYN.toUpperCase().equals(bResLanguage ? "J" : "O")){
                            extraVeggies = true;
                        }
                    }
                    System.out.println(bResLanguage ? "Welke type brood wenst u?" : "Quel type de pain est-ce que vous desirez?");
                    System.out.println(bResLanguage ? "     1 - Wit" : "     1 - Blanc");
                    System.out.println(bResLanguage ? "     2 - Grijs" : "     2 - Gris");
                    String breadTypeSelected = scanner.nextLine();
                    if (StringUtils.isNumeric(breadTypeSelected)) {
                        breadSelected =Integer.parseInt(breadTypeSelected);
                        breadType = (breadSelected >1);


                    }

                    System.out.print(bResLanguage ? "Hebt u nog opmerkingen? (J/N) " : "Avez vous encore des remarues? (O/N) "  + " : ");
                    resYN = scanner.nextLine();
                    if(resYN.toUpperCase().equals(bResLanguage ? "J" : "O")){
                        System.out.println((bResLanguage ? "Opmerkingen" : "Remarques") + " : ");
                        orderComments = scanner.nextLine();
                    }

                    Person p1 = new Person(aName);
                    Course c1 = new Course(aCourseName);

                    Sandwich sw1 = new Sandwich(nameSelected, extraVeggies, breadType,sType);
                    Order order = new Order(p1, c1, sw1);

                    OrderSystem os = new OrderSystem();
                    os.addOrder(order);

                    System.out.print(bResLanguage ? "Bestelling voltooid!" : "Commande terminé!"  + " : ");

                }
            }
        }
        else{
            System.out.println(bResLanguage ? "!!! Er is een fout opgetreden !!!" : "!!! Une erreur c'est produite !!!");
        }




    }

}
