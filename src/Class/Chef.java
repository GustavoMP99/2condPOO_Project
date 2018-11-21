package Class;
/**
 * Class for chef
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Chef extends Person {

    public Chef(int id, String password,String name) {
        super(id, password, name);
    }

    @Override
    public String getType() {
        return "Chef";
    }
}
