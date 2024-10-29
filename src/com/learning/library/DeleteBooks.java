package com.learning.library;

import java.util.Scanner;

public class DeleteBooks implements Operation{
    @Override
    public void operation(Database database,User user) {

        Scanner s= new Scanner(System.in);
        System.out.println("Enter book name: ");
        String bookName=s.next();

        int i = database.getBook(bookName);
        if(i>-1){
            database.deleteBook(i);
            System.out.println("Book deleted successfully\n");
        }
        else {
            System.out.println("Book doesn't exist!\n");
        }
        user.menu(database, user);

    }
}
