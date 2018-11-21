package Class;

/**
 * Class for ingredients
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Ingredients extends Food {

    public Ingredients(int code, String name, String description, int price, String presentation,String image) {
         super(code,name,description,price,presentation,image);
    }

    @Override
    public String getType() {
        return "Ingredient";
    }
}
