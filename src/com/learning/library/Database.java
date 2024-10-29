package com.learning.library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Database {
  private ArrayList<User> users = new ArrayList<User>();
  private ArrayList<String> userName = new ArrayList<String>();
  private ArrayList<Book> books = new ArrayList<Book>();
  private ArrayList<String> bookNames = new ArrayList<String>();
  private ArrayList<Order> orders = new ArrayList<Order>();
  private ArrayList<Borrowing> borrowings = new ArrayList<Borrowing>();

  private File userFail = new File("C:\\Library Management System\\Data\\Users");
  private File booksFail = new File("C:\\Library Management System\\Data\\Books");
  private File folder = new File("C:\\Library Management System\\Data");
  private File borrowingsFile = new File("C:\\Library Management System\\Data\\Borrowing");

  private File ordersFile = new File("C:\\Library Management System\\Data\\Orders");

  public Database() {
    if (!folder.exists()) {
      folder.mkdirs();
    }
    if (!userFail.exists()) {
      try {
        userFail.createNewFile();
      } catch (Exception e) {
      }
    }
    if (!booksFail.exists()) {
      try {
        booksFail.createNewFile();
      } catch (Exception e) {
      }
    }
    if (!ordersFile.exists()) {
      try {
        ordersFile.createNewFile();
      } catch (Exception e) {
      }
    }
    if (!borrowingsFile.exists()) {
      try {
        borrowingsFile.createNewFile();
      } catch (Exception e) {
      }
    }
    getUsers();
    getBooks();
    getOrders();
    getBorrowings();
  }

  public void addUser(User s) {
    users.add(s);
    userName.add(s.getName());
    saveUsers();
  }

  public int login(String phoneNumber, String email) {
    int n = -1;
    for (User s : users) {
      if (s.getPhoneNumber().matches(phoneNumber) && s.getEmail().matches(email)) {
        n = users.indexOf(s);
        break;

      }
    }
    return n;
  }

  public User getUser(int n) {
    return users.get(n);
  }

  public void AddBook(Book book) {
    books.add(book);
    bookNames.add(book.getName());
    saveBooks();
  }

  private void getUsers() {
    String text1 = "";
    try {
      BufferedReader br1 = new BufferedReader(new FileReader(userFail));
      String s1;
      while ((s1 = br1.readLine()) != null) {
        text1 = text1 + s1;
      }
      br1.close();
    } catch (Exception e) {
      System.err.println(e);
    }
    if (!text1.matches("") || !text1.isEmpty()) {
      String[] a1 = text1.split("<NewUser");
      for (String s : a1) {
        String[] a2 = s.split("<N/>");
        User user;
        if (a2[3].matches("Admin")) {
          user = new Admin(a2[0], a2[1], a2[2]);
        } else {
          user = new Guest(a2[0], a2[1], a2[2]);
        }
        addUser(user);
      }
    }

  }

  private void saveUsers() {
    String text1 = "";
    for (User user : users) {
      text1 = text1 + user.toString() + "<NewUser/>\n";
    }
    try {
      PrintWriter pw = new PrintWriter(userFail);
      pw.print(text1);
      pw.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
  }

  private void saveBooks() {
    String text1 = "";
    for (Book book : books) {
      text1 = text1 + book.toString2() + "<NewBook/>\n";
    }
    try {
      PrintWriter pw = new PrintWriter(booksFail);
      pw.print(text1);
      pw.close();
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  private void getBooks() {
    String text1 = "";
    try {
      BufferedReader br1 = new BufferedReader(new FileReader(booksFail));
      String s1;
      while ((s1 = br1.readLine()) != null) {
        text1 = text1 + s1;
      }
      br1.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
    if (!text1.matches("") || !text1.isEmpty()) {
      String[] a1 = text1.split("<NewBook/>");
      for (String s : a1) {
        Book book = parseBook(s);
        books.add(book);
        bookNames.add(book.getName());

      }
    }
  }

  public Book parseBook(String s) {
    String[] a = s.split("<N/");
    Book book = new Book();
    book.setName(a[0]);
    book.setAuthor(a[1]);
    book.setPublisher(a[2]);
    book.setAddress(a[3]);
    book.setQuality(Integer.parseInt(a[4]));
    book.setPrice(Double.parseDouble(a[5]));
    book.setBorrowCopies(Integer.parseInt(a[6]));
    return book;
  }

  public ArrayList<Book> getAllBooks() {
    return books;

  }

  public int getBook(String bookNames) {
    int i = -1;
    for (Book book : books) {
      if (book.getName().matches(bookNames)) {
      }
      i = books.indexOf(book);
    }
    return i;
  }

  public Book getBook(int i) {
    return books.get(i);
  }

  public void deleteBook(int i) {
    books.remove(i);
    bookNames.remove(i);
    saveBooks();
  }

  public void deleteAllData() {
    if (userFail.exists()) {
      try {
        userFail.delete();
      } catch (Exception e) {
      }
    }
    if (!booksFail.exists()) {
      try {
        booksFail.delete();
      } catch (Exception e) {
      }
    }
    if (!ordersFile.exists()) {
      try {
        ordersFile.delete();
      } catch (Exception e) {
      }

    }
    if (!borrowingsFile.exists()) {
      try {
        borrowingsFile.delete();
      } catch (Exception e) {
      }

    }
  }

  public void addOrder(Order order,Book book,int bookIndex) {
    orders.add(order);
    books.set(bookIndex,book);
    saveOrders();
    saveBooks();
  }

  private void saveOrders() {
    String text1 = "";
    for (Order order : orders) {
      text1 = text1 + order.toString2() + "<NewOrder/>\n";
    }
    try {
      PrintWriter pw = new PrintWriter(ordersFile);
      pw.print(text1);
      pw.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
  }

  private void getOrders() {
    String text1 = "";
    try {
      BufferedReader br1 = new BufferedReader(new FileReader(ordersFile));
      String s1;
      while ((s1 = br1.readLine()) != null) {
        text1 = text1 + s1;
      }
      br1.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
    if (!text1.matches("") || !text1.isEmpty()) {
      String[] a1 = text1.split("<NewOrder/>");
      for (String s : a1) {
        Order order = parseOrder(s);
        orders.add(order);
      }
    }
  }
  private User getUserByName(String name){
    User u = new Guest("");
    for(User user:users){
      if(user.getName().matches(name)){
        u= user;
        break;
      }
    }
    return u;
  }
  public  boolean userExists(String name){
    boolean f = false;
    for (User user: users){
      if(user.getName().toLowerCase().matches(name.toLowerCase())){
        f = true;
        break;
      }
    }
    return  f;
  }

  private Order parseOrder(String s){
    String[] a=s.split("<N/>");
    Order order = new Order(books.get(getBook(a[0])),getUserByName(a[1]),Double.parseDouble(a[2]),
            Integer.parseInt(a[3]));
    return order;
  }
  public ArrayList<Order> getAllOrders(){
    return  orders;
  }
  private void setBorrowings(){
    String text1 = "";
    for (Borrowing borrowing : borrowings) {
      text1 = text1 + borrowing.toString2() + "<NewBorrowing/>\n";
    }
    try {
      PrintWriter pw = new PrintWriter(borrowingsFile);
      pw.print(text1);
      pw.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
  }
  private void getBorrowings(){
    String text1 = "";
    try {
      BufferedReader br1 = new BufferedReader(new FileReader(borrowingsFile));
      String s1;
      while ((s1 = br1.readLine()) != null) {
        text1 = text1 + s1;
      }
      br1.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
    if (!text1.matches("") || !text1.isEmpty()) {
      String[] a1 = text1.split("<NewBorrowing/>");
      for (String s : a1) {
        Borrowing borrowing = parseBorrowing(s);
        borrowings.add(borrowing);
      }
    }
  }
  private Borrowing parseBorrowing(String s){
    String[] a =s.split("<N/>");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate start=LocalDate.parse(a[0],formatter);
    LocalDate finish=LocalDate.parse(a[1],formatter);
    Book book = getBook(getBook(a[3]));
    User user = getUserByName(a[4]);
    Borrowing brw = new Borrowing(start,finish,book,user);
    return brw;
  }
  private void saveBorrowings() {
    String text1 = "";
    for (Borrowing borrowing : borrowings) {
      text1 = text1 + borrowing.toString2() + "<NewBorrowing/>\n";
    }
    try {
      PrintWriter pw = new PrintWriter(borrowingsFile);
      pw.print(text1);
      pw.close();
    } catch (Exception e) {
      System.err.println(e.toString());
    }
  }
  public  void borrowBook(Borrowing brw,Book book ,int bookIndex){
    borrowings.add(brw);
    books.set(bookIndex,book);
    saveBorrowings();
    saveBooks();
  }
  public ArrayList<Borrowing> getBrw(){
    return borrowings;
  }
  public void returnBook(Borrowing b,Book book,int bookIndex){
    borrowings.remove(b);
    books.set(bookIndex,book);
    saveBorrowings();
    saveBooks();
  }
}

