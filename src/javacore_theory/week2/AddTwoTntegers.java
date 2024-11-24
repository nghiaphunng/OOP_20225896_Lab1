package javacore_theory.week2;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class AddTwoTntegers {
    String a;
    String b;
    int d = 0;
    int r = 0;

    ArrayList<String> arrayList = new ArrayList<>();

    private void input(){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parts = input.split(" ");
        a = parts[0];
        b = parts[1];

        sc.close();
    }

    private void solve(){
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 && j >= 0){
            int number1 = a.charAt(i)- '0';
            int number2 = b.charAt(j) - '0';
            d = number1 + number2 + r;
            r = d/10;
            arrayList.add(String.valueOf(d % 10));
            i--;
            j--;
        }
        while(i >= 0){
            int number1 = a.charAt(i) - '0';
            d = number1 + r;
            r = d/10;

            arrayList.add(String.valueOf(d % 10));
            i--;
        }
        while(j >= 0){
            int number2 = b.charAt(j) - '0';
            d = number2 + r;
            r = d/10;

            arrayList.add(String.valueOf(d % 10));
            j--;
        }
        while(r > 0){
            arrayList.add(String.valueOf(r));
            r = r/10;
        }
    }

    private void print(){
        for(int i = arrayList.size() - 1;i >= 0;i--){
            System.out.print(arrayList.get(i));
        }
    }
    public static void main(String[] args) {
        AddTwoTntegers addTwoTntegers = new AddTwoTntegers();
        addTwoTntegers.input();
        addTwoTntegers.solve();
        addTwoTntegers.print();
    }
}
