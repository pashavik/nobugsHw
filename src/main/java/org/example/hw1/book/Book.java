package org.example.hw1.book;

public class Book implements Displayable{
    private String name;
    private String author;
    private int year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void display() {
        System.out.println("Book name is "+getName());
        System.out.println("Author is "+getAuthor());
        System.out.println("Year of publication is "+getYear());
    }
}
