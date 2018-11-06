package Class;

import java.util.ArrayList;

public class Customer extends Person {

    private ArrayList<Food> shoppingCart;

    public Customer(int id, String password, String name) {
        super(id, password, name);
    }

    
    @Override
    public String getType() {
        return "Customer";
    }
}
