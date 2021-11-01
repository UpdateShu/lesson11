package ru.geekbrains.lessons;

import com.sun.org.apache.xpath.internal.operations.Or;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MainApp<T> {

    public static void main(String[] args) {

        MainApp<String> app = new MainApp<>();
        String[] arr = new String[] { "апельсин", "банан", "киви", "персик", "яблоко" };
        System.out.println(Arrays.toString(arr));
        app.replaceElements(arr, 0, 2);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        ArrayList<String> arrLst = app.toArrayList(arr);
        for (String a : arrLst)
            System.out.print(a + "->");

        System.out.println();
        System.out.println();
        app.testFruits();

        System.out.println();
        app.testLinkedList();
    }

    void replaceElements(T[] arr, int index1, int index2) {

        T tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    ArrayList<T> toArrayList(T[] arr) {
        ArrayList<T> arrLst = new ArrayList<T>(Arrays.asList(arr));
        return arrLst;
    }

    void testFruits() {
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 9; i++)
            addApple(appleBox);
        System.out.println("В коробке с яблоками: " + appleBox.getCount() + " шт");

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 6; i++)
            addOrange(orangeBox);
        System.out.println("В коробке с апельсинами: " + orangeBox.getCount() + " шт");

        compare(appleBox, orangeBox);
        addApple(appleBox);
        System.out.println("В коробку с яблоками добавлено: 1 шт, всего: " + appleBox.getCount() + " шт");
        compare(appleBox, orangeBox);

        Box<Apple> appleBox1 = new Box<>();
        appleBox.putToAnotherBox(appleBox1);
        System.out.println("Содержимое коробки с яблоками высыпали в другую коробку");
        System.out.println("В первой коробке яблок: " + appleBox.getCount() + " шт");
        System.out.println("Во второй коробке яблок: " + appleBox1.getCount() + " шт");
    }

    void compare(Box<Apple> appleBox, Box<Orange> orangeBox) {
        if (appleBox.compare(orangeBox))
            System.out.println("Коробки весят одинаково");
        else
            System.out.println("Коробки имеют разный вес");
    }

    void addApple(Box<Apple> appleBox) {
        Apple apple = new Apple();
        appleBox.add(apple);
    }

    void addOrange(Box<Orange> orangeBox) {
        Orange orange = new Orange();
        orangeBox.add(orange);
    }

    void testLinkedList()
    {
        MyLinkedList<Integer> lst = new MyLinkedList<>();
        lst.insertNode( 0, 111);
        System.out.println(lst.toString());
        lst.insertNode(0, 222);
        System.out.println(lst.toString());
        lst.insertNode(1, 333);
        System.out.println(lst.toString());
        lst.insertNode(0, 444);
        System.out.println(lst.toString());
        lst.addNode(555);
        lst.addNode(666);
        lst.addNode(777);
        System.out.println(lst.toString());

        lst.printNode(4);
        lst.removeNode(2);
        System.out.println(lst.toString());
        lst.removeNode(4);
        System.out.println(lst.toString());
        lst.removeNode(0);
        System.out.println(lst.toString());
        lst.removeNode(2);
        System.out.println(lst.toString());
        lst.removeNode(1);
        System.out.println(lst.toString());
        lst.removeNode(0);
        System.out.println(lst.toString());
        lst.removeNode(0);
        System.out.println(lst.toString());
    }
}
