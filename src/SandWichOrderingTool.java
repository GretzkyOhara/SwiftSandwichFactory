import model.*;

public class SandWichOrderingTool {

    public static void main (String [] args) {

//Sandwich = load hans input

        CourseParticipant student1 = new CourseParticipant("Bert ", "Christiaens");

        Sandwich sw1 = new Sandwich("Hesp",false,false);
        Course c1 = new Course("Java");

        student1.orderSandwich(c1,sw1);

    }
}
