package com.learning.library;

import java.util.Scanner;

public class BorrowBooks implements Operation{
    @Override
    public void operation(Database database,User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book name:");
        String bookName = s.next();

        int i = database.getBook(bookName);
        if(i>-1){
            Book book = database.getBook(i);
            boolean n = true;
            for (Borrowing b: database.getBrw()){
                if(b.getBook().getName().matches(bookName) &&
                        b.getUser().getName().matches(user.getName())){
                  n = false;
                    System.out.println("You have borrowed this book before!\n");
                }
            }
            if(n){
                if(book.getBorrowCopies()>1){
                    Borrowing borrowing = new Borrowing(book,user);
                    book.setBorrowCopies(book.getBorrowCopies()-1);
                    database.borrowBook(borrowing,book,i);
                    System.out.println("You must return the book before 14 days from now\n"+
                            "Expiry date:"+borrowing.getFinish()+"\nEnjoy\n");
                }else {
                    System.out.println("This book isn't available for borrowing\n");
                }
            }
        }else {
            System.out.println("Book doesn't Exist!\n");
        }
        user.menu(database, user);
    }
}
