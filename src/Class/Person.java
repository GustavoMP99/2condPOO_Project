package Class;

public abstract class Person {

    private int id;

    private String password;

    private String type;

    public Person(int id, String password) {
        this.id = id;
        this.password = password;
        this.type = type;
    }
    
    

    protected abstract String getType();
}
