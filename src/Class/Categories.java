package Class;

import java.util.ArrayList;

public class Categories {

    private ArrayList<Dish> listDish;
    private ArrayList<Drink> listDrink;
    private ArrayList<Ingredients> listIngredients;
    private String name;

    public Categories(String name) {
        this.listDish = new ArrayList<>();
        this.listDrink = new ArrayList<>();
        this.listIngredients = new ArrayList<>();
        this.name = name;
    }

    public ArrayList<Dish> getListDish() {
        return listDish;
    }

    public ArrayList<Drink> getListDrink() {
        return listDrink;
    }

    public ArrayList<Ingredients> getListIngredients() {
        return listIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
