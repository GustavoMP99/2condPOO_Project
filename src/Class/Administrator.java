package Class;

import javax.swing.JOptionPane;
import static poo_project.POO_Project.listCategories;

public class Administrator extends Person {

    public Administrator(int id, String password, String name) {
        super(id, password, name);
    }

    @Override
    public String getType() {
        return "Admi";
    }

    /**
     * Create new categories
     * @param name 
     */
    public void addCategories(String name) {
        for (int x = 0; x < listCategories.size(); x++) {
            if (listCategories.get(x).getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "This category already exists");
                return;
            }
        }
        Categories cat = new Categories(name);
        listCategories.add(cat);
        JOptionPane.showMessageDialog(null, "It was created correctly");
    }

    /**
     * Add dishes to the categories
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param ingredients
     * @param categorie 
     */
    public void addDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie) {
        Categories tempC = searchCategorie(categorie);
        Dish newDish = new Dish(code, name, description, price, presentation, image, ingredients);
        if (tempC.getListDish()==null) {
            tempC.getListDish().add(newDish);
            JOptionPane.showMessageDialog(null, "It was created correctly");
            return;
        }
        for (int x = 0; x < tempC.getListDish().size(); x++) {
            if (tempC.getListDish().get(x).getCode() == code) {
                JOptionPane.showMessageDialog(null, "This code already exists");
                return;
            }
        }
        tempC.getListDish().add(newDish);
        JOptionPane.showMessageDialog(null, "It was created correctly");
    }

    /**
     * Search categorie
     * @param name
     * @return 
     */
    public static Categories searchCategorie(String name) {
        for (int x = 0; x < listCategories.size(); x++) {
            if (listCategories.get(x).getName().equals(name)) {
                return listCategories.get(x);
            }
        }
        return null;
    }
    
    
    /**
     * Add drinks to the categories
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie 
     */
    public void addDrink(int code, String name, String description, int price, String presentation, String image, String categorie) {
        Categories tempC = searchCategorie(categorie);
        Drink newDrink = new Drink(code, name, description, price, presentation, image);
        if (tempC.getListDrink()==null) {
            tempC.getListDrink().add(newDrink);
            JOptionPane.showMessageDialog(null, "It was created correctly");
            return;
        }
        for (int x = 0; x < tempC.getListDrink().size(); x++) {
            if (tempC.getListDrink().get(x).getCode() == code) {
                JOptionPane.showMessageDialog(null, "This code already exists");
                return;
            }
        }
        tempC.getListDrink().add(newDrink);
        JOptionPane.showMessageDialog(null, "It was created correctly");
    }
    
    /**
     * Add extra ingredients to the categories
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie 
     */
    public void addIngredientExtra(int code, String name, String description, int price, String presentation, String image,String categorie) {
        Categories tempC = searchCategorie(categorie);
        Ingredients newIngredient = new Ingredients(code, name, description, price, presentation, image);
        if (tempC.getListIngredients()==null) {
            tempC.getListIngredients().add(newIngredient);
            JOptionPane.showMessageDialog(null, "It was created correctly");
            return;
        }
        for (int x = 0; x < tempC.getListIngredients().size(); x++) {
            if (tempC.getListIngredients().get(x).getCode() == code) {
                JOptionPane.showMessageDialog(null, "This code already exists");
                return;
            }
        }
        tempC.getListIngredients().add(newIngredient);
        JOptionPane.showMessageDialog(null, "It was created correctly");
    }
    
    public void CBeditDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie){
        Categories tempC=  searchCategorie(categorie);
        Dish tempD= tempC.searchFood(code);
        
    }
}
