package model;

public class Sandwich {

    private String title;
    private boolean vegetables;
    private boolean typeOfBread;

    public Sandwich() {


    }

    public Sandwich(String title, boolean vegetables, boolean typeOfBread) {
        this.title = title;
        this.vegetables = vegetables;
        this.typeOfBread = typeOfBread;
    }
}
