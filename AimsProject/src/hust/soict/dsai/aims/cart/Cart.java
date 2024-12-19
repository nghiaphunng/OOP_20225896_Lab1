package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        // TODO Auto-generated method stub
        return itemsOrdered;
    }

    //	Total Cost of Card
    public float totalCost() {
        float total = 0;
        for(Media m: itemsOrdered) {
            total += m.getCost();
        }
        return total;
    }

    // Add Media to Cart
    public void addMedia(Media m) throws LimitExceededException {
        int size = itemsOrdered.size();
        if(size < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m);
            System.out.println("The media has been added");
        }
        else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    // Remove Media to Cart
    public void removeMedia(Media m) {
        Iterator<Media> iterator = itemsOrdered.iterator();
        while (iterator.hasNext()) {
            Media media = iterator.next();
            if (media.getTitle().equals(m.getTitle())) {
                iterator.remove();
                System.out.println("The disc has been removed");
            }
        }
        System.out.println("The media does not exist in the cart.");
    }



    // Search by ID
    public boolean search(int id) {
        for(Media m: itemsOrdered) {
            if(m.getId() == id) {
                return true;
            }
        }
        return false;
    }
    // Search by Title
    public boolean search(String title) {
        for(Media m: itemsOrdered) {
            if(m.getTitle() == title) {
                return true;
            }
        }
        return false;
    }
    // Print Cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 0;
        for (Media media : itemsOrdered) {
            System.out.printf("#%d: %s. %.2f $\n", ++i, media.getTitle(), media.getCost());
        }

        float totalCost = totalCost();
        System.out.println("-------------------------------------");
        System.out.printf("===> Total cost: %.2f $\n", totalCost);
        System.out.println("***************************************************");
    }


    public void printLength() {
        System.out.println(itemsOrdered.size());
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media media1, Media media2) {
                return media1.getTitle().compareTo(media2.getTitle());
            }
        });
        System.out.println("Cart sorted by title.");
        printCart();
    }
    public void sortByCost() {
        Collections.sort(itemsOrdered, new Comparator<Media>() {
            @Override
            public int compare(Media media1, Media media2) {
                return Float.compare(media1.getCost(), media2.getCost());
            }
        });
        System.out.println("Cart sorted by cost.");
        printCart();
    }

    public Media searchMedia(String title) {
        for(Media m: itemsOrdered) {
            if(m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
    }

    public void removeMediaAll() {
        itemsOrdered.removeAll(itemsOrdered);
    }
}