package Class;

public class Deliver extends Person {

    public Deliver(int id, String password, String name) {
        super(id, password, name);
    }

    @Override
    public String getType() {
        return "Deliver";
    }
}
