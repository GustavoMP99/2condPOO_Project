package Class;

/**
 * Class for the dish
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Dish extends Food {

    private String ingredients;

    /**
     * Constructor of dish
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param ingredients 
     */
    public Dish(int code, String name, String description, int price, String presentation, String image, String ingredients) {
        super(code,name,description,price,presentation,image);
        this.ingredients= ingredients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String getType() {
        return "Dish";
    }
    
    
}
