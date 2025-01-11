package Model;

//importing required packages
import java.util.List;

import java.io.Serializable;


//implementing item class 
public class Item implements Serializable {

    //declaring variables for item information 
    private int prodId;
    private String prodDesc;
    private double price;;

    // constructor to initialize values for variables 
    public Item(int prodId, String prodDesc, double price) {
        this.prodId = prodId;
        this.prodDesc = prodDesc;
        this.price = price;
    }

    // getter methods for prodId, prodDesc and price of item 
    
    public int getProdId() {
        return prodId;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public double getProdPrice() {
        return price;
    }

    //setters methods for description and price of item 

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }
    public void setProdPrice(double price) {
        this.price = price;
    }

    //method to create a string from all item details
    @Override
    public String toString() {
        return String.format(prodId+" "+prodDesc+"  $"+price+"\n");
    }
}