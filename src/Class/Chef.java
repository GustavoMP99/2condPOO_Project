package Class;

public class Chef extends Person {

    public Chef(int id, String password,String name) {
        super(id, password, name);
    }

    @Override
    public String getType() {
        return "Chef";
    }
}
