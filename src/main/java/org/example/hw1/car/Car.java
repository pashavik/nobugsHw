package org.example.hw1.car;

public class Car implements Drivable {
    String brand;
    String model;
    int year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void start() {
        System.out.println("Начало движения");
    }

    @Override
    public void stop() {
        System.out.println("Остановка");
    }

    @Override
    public void distance() {
        System.out.println("Пройдена дистанция 100км");
    }
}
