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
     *
     * @param name
     */
    public boolean addCategories(String name) {
        for (int x = 0; x < listCategories.size(); x++) {
            if (listCategories.get(x).getName().equals(name)) {
                return false;
            }
        }
        Categories cat = new Categories(name);
        listCategories.add(cat);
        return true;
    }

    /**
     * Add dishes to the categories
     *
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param ingredients
     * @param categorie
     */
    public boolean addDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie) {
        Categories tempC = searchCategorie(categorie);
        if (verFood(code)) {
            Dish newDish = new Dish(code, name, description, price, presentation, image, ingredients);
            tempC.getListDish().add(newDish);
            return true;
        }
        return false;
    }

    /**
     * Search categorie
     *
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
     *
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie
     */
    public boolean addDrink(int code, String name, String description, int price, String presentation, String image, String categorie) {
        Categories tempC = searchCategorie(categorie);
        if (verFood(code)) {
            Drink newDrink = new Drink(code, name, description, price, presentation, image);
            tempC.getListDrink().add(newDrink);
            return true;
        }
        return false;
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

    public boolean verFood(int code) {
        for (int i = 0; i < listCategories.size(); i++) {
            for (int j = 0; j < listCategories.get(i).getListDish().size(); j++) {
                if (listCategories.get(i).getListDish().get(j).getCode() == code) {
                    return false;
                }
            }
            for (int j = 0; j < listCategories.get(i).getListDrink().size(); j++) {
                if (listCategories.get(i).getListDrink().get(j).getCode() == code) {
                    return false;
                }
            }
            for (int j = 0; j < listCategories.get(i).getListIngredients().size(); j++) {
                if (listCategories.get(i).getListIngredients().get(j).getCode() == code) {
                    return false;
                }
            }
        }
        return true;

    }
    
    public void EditDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie){
        Categories tempC=  searchCategorie(categorie);
        Dish tempD= tempC.searchDish(code);
        tempD.setDescription(description);
        tempD.setIngredients(ingredients);
        tempD.setImage(image);
        tempD.setPresentation(presentation);
        tempD.setPrice(price);
        tempD.setName(name);
    }
    
    public void EditDrink(int code, String name, String description, int price, String presentation, String image, String categorie){
        Categories tempC=  searchCategorie(categorie);
        Drink tempD= tempC.searchDrink(code);
        tempD.setDescription(description);
        tempD.setImage(image);
        tempD.setPresentation(presentation);
        tempD.setPrice(price);
        tempD.setName(name);
    }
    
     public void EditIngredient(int code, String name, String description, int price, String presentation, String image, String categorie){
        Categories tempC=  searchCategorie(categorie);
        Ingredients tempE= tempC.searchIngredient(code);
        tempE.setDescription(description);
        tempE.setImage(image);
        tempE.setPresentation(presentation);
        tempE.setPrice(price);
        tempE.setName(name);
    }
}
