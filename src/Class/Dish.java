package Class;

public class Dish extends Food {

    private String ingredients;

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
    
    
}
