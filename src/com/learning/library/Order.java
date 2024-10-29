package com.learning.library;

public class Order {
    private Book book;
    private User user;
    private  double price;
    private int quality;

    public Order(){}

    public Order(Book book,User user,double price,int quality){
        this.book = book;
        this.user=user;
        this.price=price;
        this.quality=quality;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
    public String toString(){
        return "Book name:"+book.getName()+"\n"+
                "User name:"+user.getName()+"\n"+
                "Price:"+String.valueOf(price)+"\n"+
                "Quality:"+String.valueOf(quality);
    }
    public String toString2(){
        return book.getName()+"\n"+user.getName()+"\n"+
                String.valueOf(price)+"\n"+String.valueOf(quality);
    }
}
