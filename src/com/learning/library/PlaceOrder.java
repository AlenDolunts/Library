package com.learning.library;

import java.util.Scanner;

public class PlaceOrder implements Operation{
    @Override
    public void operation(Database database,User user) {
        Order order = new Order();
        System.out.println("\nEnter book name:");
        Scanner s =new Scanner(System.in);
        String bookName = s.next();
        int i = database.getBook(bookName);
        if(i<=-1){
            System.out.println("Book doesn't exist!");
        }else {
            Book book =database.getBook(i);
            order.setBook(database.getBook(i));
            order.setUser(user);
            System.out.println("Enter Quality:");
            int quality = s.nextInt();
            order.setQuality(quality);
            order.setPrice(book.getPrice()*quality);
            int bookIndex=database.getBook(book.getName());
            book.setQuality(book.getQuality()-quality);
            database.addOrder(order,book,bookIndex);
            System.out.println("Order placed successfully!\n");
        }
        user.menu(database, user);

    }
}
