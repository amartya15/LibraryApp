package com.example.libraryapp;

public class bookstructure {
    String name,category,location;
    int weight,price;
    int itemid;

    boolean isselected;

    public bookstructure( boolean isselected,String name,String category,int weight,int price,String location,int itemid) {
        this.name = name;
        this.category = category;
        this.weight = weight;
        this.price = price;
        this.location = location;
        this.itemid = itemid;
        this.isselected = isselected;
       // this.location = location;

    }

  /*  public String getName() {
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBookId() {
        return bookid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setBookId(int bookid) {
        this.bookid = bookid;
    }

    public boolean isIsselected() {
        return isselected;
    }

    public void setIsselected(boolean isselected) {
        this.isselected = isselected;
    }
*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String name) {
        this.location = location;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public boolean isIsselected() {
        return isselected;
    }

    public void setIsselected(boolean isselected) {
        this.isselected = isselected;
    }
}
