package com.learning.library;

public class Book {
    private  String name;
    private String author;
    private String publisher;
    private String address;
    private String status;
    private int quality;
    private double price;
    private int borrowCopies;

    public Book(){};

    public Book(String name,String author,String publisher,
                String address,int quality,double price,int borrowCopies){

      this.name=name;
      this.author=author;
      this.publisher=publisher;
      this.address=address;
      this.quality=quality;
      this.price=price;
      this.borrowCopies=borrowCopies;

    }
    public String toString(){
        String text ="Book Name:"+name+ "\n"+"Book Author:"+ author+"\n"+
                    "Book Publisher:"+publisher+"\n"+"Book Collection Address:"+address+"\n"+
                    " Quality:"+String.valueOf(quality)+"\n"+"Price"+String.valueOf(price)+"\n"+
                   "Borrowing Copies:"+String.valueOf(borrowCopies);
         return text;


    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBorrowCopies() {
        return borrowCopies;
    }

    public void setBorrowCopies(int borrowCopies) {
        this.borrowCopies = borrowCopies;
    }

    public String toString2(){
        String text =name+"<N/>"+ author+ "<N/>"+publisher+"<N/>:"+address+
                "<N/>"+String.valueOf(quality)+"<N/>"+String.valueOf(price)+
                "<N/>"+String.valueOf(borrowCopies);
        return text;
    }

}
