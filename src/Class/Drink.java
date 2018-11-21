package Class;
/**
 * Class drink
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Drink extends Food {

    /**
     * Constructor of drink
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image 
     */
    public Drink(int code, String name, String description, int price, String presentation, String image) {
        super(code,name,description,price,presentation,image);
    }

    @Override
    public String getType() {
        return "Drink";
    }
}
