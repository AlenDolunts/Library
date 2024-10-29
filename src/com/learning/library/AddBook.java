package com.learning.library;

import java.util.Scanner;

public class AddBook implements Operation{
    @Override
    public void operation(Database database,User user){
        Scanner s=new Scanner(System.in);
        Book book = new Book();
        System.out.println("\nEnter book name: ");
        String name=s.next();
        if(database.getBook(name)>-1){
            System.out.println("There is a book with this name!\n");
            user.menu(database, user);
            return;
        }
        else {
            book.setName(name);
            book.setName(s.next());
            System.out.println("Enter book author: ");
            book.setAuthor(s.next());
            System.out.println("Enter book publisher: ");
            book.setPublisher(s.next());
            System.out.println("Enter book collection location: ");
            book.setAddress(s.next());
            System.out.println("Enter book quality: ");
            book.setQuality(s.nextInt());
            System.out.println("Enter book price: ");
            book.setPrice(s.nextDouble());
            System.out.println("Enter borrowing copies: ");
            book.setBorrowCopies(s.nextInt());
            database.AddBook(book);
            System.out.println("Book added successfully\n");
            s.close();
        }
    }

}
