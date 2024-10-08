package org.example.hw1.student;

public class Student implements Printable{
    String name;
    int bookNumber;
    double avgScore;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(int bookNumber) {
        this.bookNumber = bookNumber;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    @Override
    public void print() {
        System.out.println("Student's name is " + getName());
        System.out.println("Student's record-book number is " + getBookNumber());
        System.out.println("Student's average score is " + getAvgScore());
    }
}
