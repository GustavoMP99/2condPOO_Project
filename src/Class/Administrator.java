package Class;

public class Administrator extends Person {

    public Administrator(int id, String password, String name) {
        super(id,password, name);
    }

    @Override
    public String getType() {
        return "Admi";
    }
}
