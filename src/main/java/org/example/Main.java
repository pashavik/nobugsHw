package org.example;

import org.example.hw1.book.Book;
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

    }
}