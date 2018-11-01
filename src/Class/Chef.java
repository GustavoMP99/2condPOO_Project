package Class;

public class Chef extends Person {

    public Chef(int id, String password) {
        super(id, password);
    }

    @Override
    protected String getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
