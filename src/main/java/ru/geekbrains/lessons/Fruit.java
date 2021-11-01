package ru.geekbrains.lessons;

public abstract class Fruit {

    private String name;
    private double weight;

    public Fruit() {}

    public Fruit(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public double getWeight() {
        return weight;
    }

    public abstract Fruit createFruit();
    public abstract void incCount();
    public abstract void clearCount();
}
