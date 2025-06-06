package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Order {

    private Person person;
    private Course course;
    private Sandwich sandwich = new Sandwich ();
    private String orderComments = "";

    public Order() {
    }

     public Order(Person person, Course course, Sandwich sandwich, String orderComments) {
        this.person = person;
        this.course = course;
        this.sandwich = sandwich;
        this.orderComments = orderComments;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getOrderComments() {
        return orderComments;
    }

    public void setOrderComments(String orderComments) {
        this.orderComments = orderComments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "person=" + person +
                ", course=" + course +
                ", sandwich=" + sandwich +
                ", orderComments='" + orderComments + '\'' +
                '}';
    }
}

