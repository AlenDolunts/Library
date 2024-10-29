package com.learning.library;

import java.util.Scanner;

public class CalculateFine implements Operation{
    @Override
    public void operation(Database database,User user) {
        System.out.println("Enter book name");
        System.out.println("Enter book name:");
        Scanner s =new Scanner(System.in);
        String bookName = s.next();

        boolean g = true;
        for(Borrowing b : database.getBrw() ){
            if(b.getBook().getName().matches(bookName) && b.getUser().getName().matches(user.getName())){
                if(b.getDaysLeft()>0){
                    System.out.println("You are late!\n"+"You have to pay"+b.getDaysLeft()*50+"as fine\n");
                }else {
                    System.out.println("Fine you don't have to pay\n");
                }
                g = false;
                break;
            }
        }
        if(g){
            System.out.println("You didn't borrow this book");
        }
        user.menu(database, user);
    }
}
