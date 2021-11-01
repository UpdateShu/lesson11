package ru.geekbrains.lessons;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public int getCount() {
        return fruits.size();
    }

    public double getWeight() {
        double weight = 0;
        for (T fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    /*public T add() {
        T fruit = new T();
        return fruit;
    }*/

    public void add(T fruit) {
        fruits.add(fruit);
        fruit.incCount();
    }

    public boolean compare(Box<?> box) {
        return this.getWeight() == box.getWeight();
    }

    public void putToAnotherBox(Box<T> another) {

        for (T fruit : this.fruits) {
            another.add(fruit);
        }
        if (this.fruits.size() != 0)
            this.fruits.get(0).clearCount();
        this.fruits.clear();
    }
}
