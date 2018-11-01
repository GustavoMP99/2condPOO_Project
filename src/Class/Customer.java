package Class;

import java.util.ArrayList;

public class Customer extends Person {

    private ArrayList<Food> shoppingCart;

    public Customer(int id, String password) {
        super(id, password);
    }

    
    @Override
    protected String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
