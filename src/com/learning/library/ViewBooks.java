package com.learning.library;

import java.util.ArrayList;

public class ViewBooks implements Operation {
    @Override
    public void operation(Database database,User user){
        ArrayList<Book> books= database.getAllBooks();
        System.out.println("Name\t\tAuthor\t\tPublisher\tCollection location Address" +
                "\tQuality\tPrice\tBorrowing copies");
        for (Book b: books){
            System.out.println(b.getName()+"\t\t"+b.getAuthor()+"\t\t"+b.getPublisher()+"\t\t"+
                    b.getAddress()+"\t"+b.getQuality()+"\t"+b.getPrice()+"\t"+b.getBorrowCopies());
        }
        System.out.println();
        user.menu(database,user);
    }

}
