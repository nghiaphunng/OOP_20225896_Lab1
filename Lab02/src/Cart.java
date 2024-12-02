package javacore_lab.Lab02;

public class Cart {
   public static final int MAX_NUMBERS_ORDERED = 20;
   private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
   private int qtyOrdered;

   public void addDigitalVideoDisc(DigitalVideoDisc disc){
      if(qtyOrdered >= 20){
         System.out.println("The cart is full");
      }
      else {
         itemsOrdered[qtyOrdered] = disc;
         qtyOrdered++;
         System.out.println("The disc has been added");
         if(qtyOrdered >= MAX_NUMBERS_ORDERED - 2){
            System.out.println("The cart is almost full");
         }
      }
   }

   public void removeDigitalVideoDisc(DigitalVideoDisc disc){
      boolean foundDisc = false;

      for (int i = 0; i < qtyOrdered; i++) {
         if (itemsOrdered[i] == disc) {
            foundDisc = true;
            for (int j = i; j < qtyOrdered - 1; j++) {
               itemsOrdered[j] = itemsOrdered[j + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed");
            break;
         }
      }

      if (!foundDisc) {
         System.out.println("The disc is not found in the cart");
      }
   }

   public float totalCost(){
      float total = 0;
      for (int i = 0; i < qtyOrdered; i++) {
         total += itemsOrdered[i].getCost();
      }
      return total;
   }
}
