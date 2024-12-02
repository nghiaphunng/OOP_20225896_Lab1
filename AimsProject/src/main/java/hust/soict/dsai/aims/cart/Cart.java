package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;

public class Cart {
   private ArrayList<Media> itemsOrdered = new ArrayList<>();

   //add media
   public void addMedia(Media media){
      if(itemsOrdered.size() >= 20){
         System.out.println("The cart is full");
      }
      else {
         itemsOrdered.add(media);
         System.out.println("The media has been added");
      }
   }

   //remove media
   public void removeMedia(Media media){
      if(itemsOrdered.contains(media)){
         itemsOrdered.remove(media);
         System.out.println("The media has been removed");
      }
      else {
         System.out.println("Not found media");
      }
   }

   public float totalCost(){
      float total = 0;
      for (Media media : itemsOrdered) {
         total += media.getCost();
      }
      return total;
   }

   public void print(){
      System.out.println("***********************CART***********************");
      System.out.println("Ordered Items:");

      float totalCost = 0;

      for(int i = 0;i < itemsOrdered.size();i++){
         System.out.println((i + 1) + ". " + itemsOrdered.get(i).toString());
      }
      System.out.printf("Total cost: %.2f $%n", totalCost());
      System.out.println("***************************************************");
   }

   //search by id
   public Media searchById(int id){
      for(Media media : itemsOrdered){
         if(media.getId() == id){
            return media;
         }
      }
      return null;
   }

   //search by title
   public Media searchByTitle(String title){
      for(Media media : itemsOrdered){
         if(media.isMatch(title)){
            return media;
         }
      }
      return null;
   }
//
//   //filter by title
//   public void filterByTitle(String keyTitle){
//      for(Media media : itemsOrdered){
//         if(media.getTitle().contains(keyTitle)){
//            System.out.println(media);
//         }
//      }
//   }
//
//   //filter by cost
//   public void filterById(int id){
//      for(Media media : itemsOrdered){
//         if(media.getId() == id){
//            System.out.println(media);
//         }
//      }
//   }

   //sort by title
   public void sortByTitle(){
      itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
      print();
   }

   //sort by cost
   public void sortByCost(){
      itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
      print();
   }

   //empty
   public void emptyCart(){
      itemsOrdered.clear();
   }
}

