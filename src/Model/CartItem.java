package Model;

//implementing class CartItem from CartItemAbstract class
public class CartItem extends CartItemAbstract {
    
    //declaring private variable for item 
    private Item item;

    //constructor for setting the item 
    public CartItem(Item item, int qty) {
        super(qty);
        this.item = item;
    }

    //getter method for item
    public Item getItem() {
        return item;
    }

    //method for getting total price of items using quantity and price
    @Override
    public double getTotalPrice() {
        return item.getProdPrice() * getProdQty();
    }
}
