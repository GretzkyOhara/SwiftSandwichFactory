package model;

public class CourseParticipant extends Person {


    private static int numberOfSandWiches = 0;
    private Course course;

    public CourseParticipant() {

    }



    public void orderSandwich(Sandwich sandWich) {

    }

    public static int getNumberOfSandWiches() {
        return numberOfSandWiches;
    }

    public static void setNumberOfSandWiches(int numberOfSandWiches) {
        CourseParticipant.numberOfSandWiches = numberOfSandWiches;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
