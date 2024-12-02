package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.Playable;

import java.util.Scanner;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();

    //method control
    public static void showMenu(){
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void viewStore(Scanner sc){
        int choice;
        do {
            store.display();
            storeMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    seeMediaDetails(sc);
                    break;
                case 2:
                    addMediaToCart(sc);
                    break;
                case 3:
                    playMedia(sc);
                    break;
                case 4:
                    seeCurrentCart(sc);
                    break;
                case 0:
                    System.out.println("Back");
                    break;
                default:
                    System.out.println("Please choose again");
            }
        }while(choice != 0);
    }

    public static void seeMediaDetails(Scanner sc){
        System.out.println("Enter title of media: ");
        String title = sc.nextLine();

        Media media = store.searchByTitle(title);
        if(media != null){
            System.out.println(media);
            int choice;
            do{
                mediaDetailsMenu();
                choice = sc.nextInt();
                sc.nextLine();
                switch (choice){
                    case 1:
                        cart.addMedia(media);
                        break;
                    case 2:
                        if(media instanceof Playable){
                            ((Playable) media).play();
                        }
                        else {
                            System.out.println("This media cannot play");
                        }
                        break;
                    case 0:
                        System.out.println("Back to store menu");
                        break;
                    default:
                        System.out.println("Please choose again");
                }
            }while(choice != 0);
        }
        else{
            System.out.println("Media not found");
        }
    }
    public static void addMediaToCart(Scanner sc){
        System.out.println("Enter the title: ");
        String title = sc.nextLine();

        Media media = store.searchByTitle(title);
        if(media != null){
            cart.addMedia(media);
        }
        else{
            System.out.println("Media not found");
        }
    }
    public static void playMedia(Scanner sc){
        System.out.println("Enter the title: ");
        String title = sc.nextLine();
        Media media = store.searchByTitle(title);
        if(media != null){
            if(media instanceof Playable){
                ((Playable) media).play();
            }
            else {
                System.out.println("This media cannot play");
            }
        }
        else {
            System.out.println("Media not found");
        }
    }
    public static  void seeCurrentCart(Scanner sc){
        cart.print();
        int choice;
        do{
            cartMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    filterCart(sc);
                    break;

                case 2:
                    sortCart(sc);
                    break;

                case 3:
                    removeMediaFromCart(sc);
                    break;

                case 4:
                    playMedia(sc);
                    break;

                case 5:
                    placeOrder();
                    break;

                case 0:
                    System.out.println("Back");
                    break;

                default:
                    System.out.println("Please choose again");
            }
        } while (choice != 0);
    }

    public static void updateStore(Scanner sc){
        System.out.println("------Update Store------");
        System.out.println("1.Add media to store");
        System.out.println("2.Remove media from store");
        System.out.println("Please choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter information of media");
                System.out.println("Enter media type: 1.Book     2.DVD     3.CD");
                int mediaType = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter title: ");
                String title = sc.nextLine();
                System.out.println("Enter cost: ");
                float cost = sc.nextFloat();
                sc.nextLine();

                switch (mediaType){
                    case 1:
                        System.out.println("Enter number of authors: ");
                        int numAuthors = sc.nextInt();
                        sc.nextLine();
                        Book book = new Book();
                        book.setTitle(title);
                        book.setCost(cost);
                        for(int i = 0;i < numAuthors;i++){
                            System.out.println("Enter author " + (i + 1) + ": ");
                            String author = sc.nextLine();
                            book.addAuthor(author);
                        }
                        store.addMedia(book);
                        break;

                    case 2:
                        DigitalVideoDisc digitalVideoDisc = new DigitalVideoDisc(title);
                        digitalVideoDisc.setTitle(title);
                        digitalVideoDisc.setCost(cost);
                        store.addMedia(digitalVideoDisc);
                        break;

                    case 3:
                        CompactDisc compactDisc = new CompactDisc();
                        compactDisc.setCost(cost);
                        compactDisc.setTitle(title);
                        store.addMedia(compactDisc);
                        break;
                }
                break;

            case 2:
                System.out.println("Enter title of the media: ");
                String removeTitle = sc.nextLine();
                Media media = store.searchByTitle(removeTitle);
                if(media != null){
                    store.removeMedia(media);
                }
                else {
                    System.out.println("Media not found");
                }
            break;
        }
    }

    public static void filterCart(Scanner sc){
        System.out.println("Filter cart by: 1.Title     2.Id");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                System.out.println("Enter title: ");
                String title = sc.nextLine();
                Media mediaByTitle = cart.searchByTitle(title);
                if(mediaByTitle != null) System.out.println(mediaByTitle);
                else System.out.println("Not found");
                break;

            case 2:
                System.out.println("Enter id: ");
                int id = sc.nextInt();
                Media mediaById = cart.searchById(id);
                if(mediaById != null) System.out.println(mediaById);
                else System.out.println("Not found");
                break;
        }
    }

    public static void removeMediaFromCart(Scanner sc) {
        System.out.println("Enter title of the media to remove: ");
        String title = sc.nextLine();
        Media media = cart.searchByTitle(title);
        if (media != null) {
            cart.removeMedia(media);
        }
        else {
            System.out.println("Media not found in cart");
        }
    }

    public static void sortCart(Scanner sc) {
        System.out.println("Sort cart by: ");
        System.out.println("1.Title");
        System.out.println("2.Cost");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                cart.sortByTitle();
                break;
            case 2:
                cart.sortByCost();
                break;
        }
    }

    public static void placeOrder(){
        System.out.println("Order placed successfully");
        cart.emptyCart();
    }

    public static void main(String[] args) {
        //example
        Book book1 = new Book("sach1", "sachhay", 10);
        Book book2 = new Book("sach2", "sachhay", 11);
        Book book3 = new Book("sach3", "sachhay", 12);
        Book book4 = new Book("sach4", "sachhay", 13);
        Book book5 = new Book("sach5", "sachhay", 14);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);

        //run
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            showMenu();
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    viewStore(sc);
                    break;
                case 2:
                    updateStore(sc);
                    break;
                case 3:
                    seeCurrentCart(sc);
                    break;
                case 0:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Please choose again");
            }
        } while(choice != 0);

        sc.close();
    }
}