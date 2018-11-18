package Class;

import java.util.ArrayList;

public class Customer extends Person {

    private ArrayList<Food> shoppingCart;

    public Customer(int id, String password, String name) {
        super(id, password, name);
        this.shoppingCart= new ArrayList<Food>();
    }

    
    @Override
    public String getType() {
        return "Customer";
    }
    public void addFood(Food tempF){
        shoppingCart.add(tempF);
    }

    public ArrayList<Food> getShoppingCart() {
        return shoppingCart;
    }
    
}
