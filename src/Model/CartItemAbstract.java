package Model;

//creating abstract class CartItemAbstract
public abstract class CartItemAbstract {

    //declaring private variable for quantity 
    private int qty;

    // constructor to set quantity
    public CartItemAbstract(int qty) {
        this.qty = qty;
    }

    //creating abstract method for getting total price of cart items
    public abstract double getTotalPrice();

    //getter and setter methods for quantity

    public int getProdQty() {
        return qty;
    }

    public void setProdQty(int qty) {
        this.qty = qty;
    }

}
