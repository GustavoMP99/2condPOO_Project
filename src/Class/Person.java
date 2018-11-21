package Class;

/**
 * Class of person
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public abstract class Person {

    private int id;
    private String password;
    private String type;
    private String name;

    public Person(int id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name= name;
        this.type = type;
    }
   
   public abstract String getType();

    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    
}
