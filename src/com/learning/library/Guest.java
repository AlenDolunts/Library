package com.learning.library;

import java.util.Scanner;

public class Guest extends User {
    public Guest(String name){
        super(name);
        this.operations = new Operation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBooks(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()


        };
    }
    public  Guest(String name,String email,String phoneNumber){
        super(name, email, phoneNumber);
        this.operations = new Operation[]{
                new ViewBooks(),
                new Search(),
                new PlaceOrder(),
                new BorrowBooks(),
                new CalculateFine(),
                new ReturnBook(),
                new Exit()
        };
    }
    @Override
    public  void menu(Database database,User user){
        System.out.println("1. View books");
        System.out.println("2. Search");
        System.out.println("3. Place order");
        System.out.println("4. Borrow books");
        System.out.println("5. Calculate fine");
        System.out.println("6. Return books");
        System.out.println("7. Exit");

        Scanner s =new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].operation(database,user);
        s.close();
    }
    public String toString(){
        return  name +"<N/>"+ email+"<N/>"+phoneNumber+"<N/>"+"Guest";
    }

}
