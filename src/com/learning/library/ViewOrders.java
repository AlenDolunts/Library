package com.learning.library;

import java.util.Scanner;

public class ViewOrders implements Operation {
    @Override
    public void operation(Database database, User user) {
        System.out.println("\nEnter book name:");
        Scanner s = new Scanner(System.in);
        String bookName = s.next();
        int i = database.getBook(bookName);
        if (i > -1) {
            System.out.println("Book\t\tUser\t\tPrice\t\tQuality\tPrice");
            for (Order order : database.getAllOrders()) {
                if (order.getBook().getName().matches(bookName)) {
                    System.out.println(order.getBook().getName()+"\t\t"+
                            order.getUser().getName()+"\t\t"+order.getQuality()+"\t"+order.getPrice());
                }
            }
            System.out.println();
        } else {
            System.out.println("Book doesn't exist!\n");
        }
        user.menu(database, user);
    }
}
