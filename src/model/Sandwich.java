package model;

import java.util.Objects;

public class Sandwich {

    private Integer num;
    private String title;
    private boolean vegetables;
    private boolean typeOfBread;
    private String sandwichType;

    public Sandwich() {


    }

    public String getSandwichType() {
        return sandwichType;
    }

    public void setSandwichType(String sandwichType) {
        this.sandwichType = sandwichType;
    }

    public Sandwich(String title, boolean vegetables, boolean typeOfBread, String sandwichType) {
        this.title = title;
        this.vegetables = vegetables;
        this.typeOfBread = typeOfBread;
        this.sandwichType = sandwichType;
    }

    public Sandwich(Integer num, String title, boolean vegetables, boolean typeOfBread, String sandwichType) {
        this.num = num;
        this.title = title;
        this.vegetables = vegetables;
        this.typeOfBread = typeOfBread;
        this.sandwichType = sandwichType;
    }

    public Integer getNum() {        return num;    }

    public void setNum(Integer num) {        this.num = num;    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVegetables() {
        return vegetables;
    }

    public void setVegetables(boolean vegetables) {
        this.vegetables = vegetables;
    }

    public boolean isTypeOfBread() {
        return typeOfBread;
    }

    public void setTypeOfBread(boolean typeOfBread) {
        this.typeOfBread = typeOfBread;
    }


    @Override
    public String toString() {
        return "Sandwich{" +
                "num=" + num +
                ", title='" + title + '\'' +
                ", vegetables=" + vegetables +
                ", typeOfBread=" + typeOfBread +
                ", sandwichType='" + sandwichType + '\'' +
                '}';
    }
}
