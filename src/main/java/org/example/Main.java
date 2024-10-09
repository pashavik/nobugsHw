package org.example;

import org.example.hw1.book.Book;
import org.example.hw1.car.Car;
import org.example.hw1.clock.Clock;
import org.example.hw1.point.Point;
import org.example.hw1.student.Student;

public class Main {
    public static void main(String[] args) {

        Book book = new Book();
        book.setAuthor("King");
        book.setName("Under the Dome");
        book.setYear(2009 );

        book.display();

        System.out.println("=======================");

        Student student = new Student();
        student.setName("Ivan");
        student.setBookNumber(10);
        student.setAvgScore(3.1);

        student.print();

        System.out.println("=======================");

        Point point = new Point();
        point.setX(1);
        point.setY(1);

        point.moveUp();
        point.moveRight();

        System.out.println(point.getX());
        System.out.println(point.getY());

        System.out.println("=======================");

        Clock clock = new Clock();
        clock.setHour(1);
        clock.setMinutes(30);
        clock.setSeconds(10);
        clock.tick();
        clock.readTime();

        System.out.println("=======================");

        Car car = new Car();
        car.setBrand("Lada");
        car.setModel("Zver'");
        car.setYear(1990);

        car.start();
        car.stop();
        car.distance();
    }
}