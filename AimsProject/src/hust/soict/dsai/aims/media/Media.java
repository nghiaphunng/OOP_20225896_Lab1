package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;

    public Media() {
        // TODO Auto-generated constructor stub
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {
        // Check if the object is compared to itself
        if (this == obj) {
            return true;
        }

        // Check if the object is null
        if (obj == null) {
            return false;
        }

        // Check if the object is an instance of Media class
        if (!(obj instanceof Media)) {
            return false;
        }

        // Cast the object to Media type
        Media otherMedia = (Media) obj;

        // Check if the titles are equal
        if (this.getTitle() == null && otherMedia.getTitle() == null) {
            return true;
        } else if (this.getTitle() == null || otherMedia.getTitle() == null) {
            return false;
        } else {
            return this.getTitle().equals(otherMedia.getTitle());
        }
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();


    public void displayInfo(){
        System.out.println("Title : " + title);
        System.out.println("Category : " + category);
        System.out.println("Cost : " + cost);
    }

}
