package com.learning.library;

import java.util.Scanner;

public class Search implements Operation{
    @Override
    public void operation(Database database,User user ){
        System.out.println("\nEnter book name");
        Scanner s = new Scanner(System.in);
        String name= s.next();
        int i = database.getBook(name);
        if(i>-1){
            System.out.println("\n"+database.getBook(i).toString()+"\n");
        }
        else {
            System.out.println("Book doesn't exist!\n");
        }
        user.menu(database, user);

    }
}
