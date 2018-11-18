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
    
    public Dish searchDish(int code){
        for (int i = 0; i < listDish.size(); i++) {
            if(listDish.get(i).getCode()==code)
                return listDish.get(i);
            }
        return null;
    }
    
     public Drink searchDrink(int code){
        for (int i = 0; i < listDrink.size(); i++) {
            if(listDrink.get(i).getCode()==code)
                return listDrink.get(i);
            }
        return null;
    }
     
      public Ingredients searchIngredient(int code){
        for (int i = 0; i < listIngredients.size(); i++) {
            if(listIngredients.get(i).getCode()==code)
                return listIngredients.get(i);
            }
        return null;
    }
}
