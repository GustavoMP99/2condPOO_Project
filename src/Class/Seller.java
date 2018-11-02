package Class;

public class Seller extends Person {

    public Seller(int id, String password) {
        super(id,password);
    }

    @Override
    protected String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
