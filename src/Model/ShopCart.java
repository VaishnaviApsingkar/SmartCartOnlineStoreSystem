package Model;

//importing required packages 
import java.util.List;

import java.util.ArrayList;

//implementing class ShoppingCart
public class ShopCart {
    
    //creating list for items
    private List<CartItem> items;

    //constructor for initialize items list
    public ShopCart() {
        this.items = new ArrayList<>();
    }

    //to get all items from cart in the form of each item as string
    public List<String> getItems() {
        List<String> itemDetails = new ArrayList<>();
        for (CartItem cartItem : items) {
            itemDetails.add(String.format("ID: %d, Description: %s, Quantity: %d", 
                            cartItem.getItem().getProdId(), cartItem.getItem().getProdDesc(), cartItem.getProdQty()));
        }
        return itemDetails;
    }

    //methods for adding and removing items 
    public void addItem(Item item, int qty) {
        for (CartItem cartItem : items) {
            if (cartItem.getItem().getProdId() == item.getProdId()) {
                cartItem.setProdQty(cartItem.getProdQty() + qty);
                return;
            }
        }
        items.add(new CartItem(item, qty));
    }

    //updating quantity of items
    public boolean updateItemQuantity(int prodId, int newQty) {
        for (CartItem cartItem : items) {
            if (cartItem.getItem().getProdId() == prodId) {
                cartItem.setProdQty(newQty);
                return true;
            }
        }
        return false;
    }

    public boolean removeItem(int prodId) {
        return items.removeIf(cartItem -> cartItem.getItem().getProdId() == prodId);
    }

    //calculating total price of items in cart
    public double getTotalPrice() {
        return items.stream().mapToDouble(cartItem -> 
        cartItem.getItem().getProdPrice() * cartItem.getProdQty() ).sum();
    }

}