package ru.geekbrains.lessons;

public class Apple extends Fruit {

    public static int COUNT = 0;

    public Apple() {
        super("яблоко", 1.0);
    }

    public double getWeight() {
        return super.getWeight();
    }

    @Override
    public Fruit createFruit() {
        return new Apple();
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
