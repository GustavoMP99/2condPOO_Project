package Class;

/**
 * Class for the deliver
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Deliver extends Person {

    public Deliver(int id, String password, String name) {
        super(id, password, name);
    }

    @Override
    public String getType() {
        return "Deliver";
    }
}
