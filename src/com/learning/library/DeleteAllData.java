package com.learning.library;

import java.util.Scanner;

public class DeleteAllData implements Operation{
    @Override
    public void operation(Database database,User user) {
        System.out.println("\nAre you sure that you want delete all data?\n"+"1. Continue\n2.Main Menu");
        Scanner s= new Scanner(System.in);
        int i= s.nextInt();
        if(i==1){
            database.deleteAllData();
        }else {
            user.menu(database, user);
        }

    }
}
