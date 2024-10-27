package javacore_lab.Lab02;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    //getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    //constructor
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.director = director;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title,  String category, String director, int length, float cost) {
        this.title = title;
        this.cost = cost;
        this.length = length;
        this.director = director;
        this.category = category;
    }
}
