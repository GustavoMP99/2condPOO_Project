package Class;

public class Seller extends Person {

    public Seller(int id, String password, String name) {
        super(id,password,name);
    }

    @Override
    public String getType() {
        return "Seller";
    }
}
