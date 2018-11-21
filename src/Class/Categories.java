package Class;

import java.util.ArrayList;

/**
 * Class categorie
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Categories {

    private ArrayList<Dish> listDish;
    private ArrayList<Drink> listDrink;
    private ArrayList<Ingredients> listIngredients;
    private String name;

    /**
     * Constructor of categorie
     * @param name 
     */
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
    
    /**
     * Method to search a dish
     * @param code
     * @return 
     */
    public Dish searchDish(int code){
        for (int i = 0; i < listDish.size(); i++) {
            if(listDish.get(i).getCode()==code)
                return listDish.get(i);
            }
        return null;
    }
    
    /**
     * Method to search a drink
     * @param code
     * @return 
     */
     public Drink searchDrink(int code){
        for (int i = 0; i < listDrink.size(); i++) {
            if(listDrink.get(i).getCode()==code)
                return listDrink.get(i);
            }
        return null;
    }
     
     /**
      * Method to search a ingredient
      * @param code
      * @return 
      */
      public Ingredients searchIngredient(int code){
        for (int i = 0; i < listIngredients.size(); i++) {
            if(listIngredients.get(i).getCode()==code)
                return listIngredients.get(i);
            }
        return null;
    }
}
