package Class;

import java.util.ArrayList;

/**
 * Class for the customer
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
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
