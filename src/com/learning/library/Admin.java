package com.learning.library;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name){
        super(name);
        this.operations = new Operation[]{
           new AddBook(),
           new ViewBooks(),
           new DeleteBooks(),
           new Search(),
           new DeleteAllData(),
           new ViewOrders(),
           new Exit()
        };
    }
    public  Admin(String name,String email,String phoneNumber){
        super(name, email, phoneNumber);
        this.operations = new Operation[]{
                new AddBook(),
                new ViewBooks(),
                new DeleteBooks(),
                new Search(),
                new DeleteAllData(),
                new ViewOrders(),
                new Exit()
        };
    }
    @Override
    public void menu(Database database,User user){
        System.out.println("1. View books");
        System.out.println("2. Add books");
        System.out.println("3. Delete books");
        System.out.println("4. Search");
        System.out.println("5. Delete all");
        System.out.println("6. View Orders");
        System.out.println("7. Exit");

        Scanner s =new Scanner(System.in);
        int n=s.nextInt();
        this.operations[n-1].operation(database,user);
        s.close();
    }
    public String toString(){
        return  name +"<N/>"+ email+"<N/>"+phoneNumber+"<N/>"+"Admin";
    }

}
