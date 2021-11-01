package ru.geekbrains.lessons;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Orange extends Fruit {

    public static int COUNT = 0;

    public Orange() {
        super("апельсин", 1.5);
    }

    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public Fruit createFruit() {
        return new Orange();
    }

    @Override
    public void incCount() {
        COUNT++;
    }

    @Override
    public void clearCount() {
        COUNT = 0;
    }
}
