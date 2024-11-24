package javacore_lab.Lab03;

import javacore_lab.Lab02.DigitalVideoDisc;

import java.lang.reflect.Field;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);

//        DigitalVideoDisc[] dvds = {jungleDVD, cinderellaDVD};
//        swap(dvds);

        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

//        System.out.println("jungle dvd title: " + dvds[0].getTitle());
//        System.out.println("cinderella dvd title: " + dvds[1].getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void swap(DigitalVideoDisc[] dvds) {
        DigitalVideoDisc tmp = dvds[0];
        dvds[0] = dvds[1];
        dvds[1] = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

