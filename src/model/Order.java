package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Person person;
    private Course course;
    private List <Sandwich> sandwichList = new ArrayList<Sandwich>();

    public Order() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Sandwich> getSandwichList() {
        return sandwichList;
    }

    public void setSandwichList(List<Sandwich> sandwichList) {
        this.sandwichList = sandwichList;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
