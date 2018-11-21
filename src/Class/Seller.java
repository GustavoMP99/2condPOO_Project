package Class;

/**
 * Class for the seller
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Seller extends Person {

    public Seller(int id, String password, String name) {
        super(id,password,name);
    }

    @Override
    public String getType() {
        return "Seller";
    }
}
