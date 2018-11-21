package Class;

import javax.swing.JOptionPane;
import static poo_project.POO_Project.listCategories;

/**
 * Class for the administrator that is a singleton
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class Administrator extends Person {

    private static Administrator soyUnico;

    private Administrator(int id, String password, String name) {
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
     *
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie
     */
    public boolean addIngredientExtra(int code, String name, String description, int price, String presentation, String image, String categorie) {
        Categories tempC = searchCategorie(categorie);
        if (verFood(code)) {
            Ingredients newIngredients = new Ingredients(code, name, description, price, presentation, image);
            tempC.getListIngredients().add(newIngredients);
            return true;
        }
        return false;
    }

    /**
     * Method to verificate if the code of the food is already
     * created
     * @param code
     * @return 
     */
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

    /**
     * Method to edit a dish
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param ingredients
     * @param categorie 
     */
    public void EditDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie) {
        Categories tempC = searchCategorie(categorie);
        Dish tempD = tempC.searchDish(code);
        tempD.setDescription(description);
        tempD.setIngredients(ingredients);
        tempD.setImage(image);
        tempD.setPresentation(presentation);
        tempD.setPrice(price);
        tempD.setName(name);
    }

    /**
     * Method to edit a drink
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie 
     */
    public void EditDrink(int code, String name, String description, int price, String presentation, String image, String categorie) {
        Categories tempC = searchCategorie(categorie);
        Drink tempD = tempC.searchDrink(code);
        tempD.setDescription(description);
        tempD.setImage(image);
        tempD.setPresentation(presentation);
        tempD.setPrice(price);
        tempD.setName(name);
    }

    /**
     * Method to edit a ingredient
     * @param code
     * @param name
     * @param description
     * @param price
     * @param presentation
     * @param image
     * @param categorie 
     */
    public void EditIngredient(int code, String name, String description, int price, String presentation, String image, String categorie) {
        Categories tempC = searchCategorie(categorie);
        Ingredients tempE = tempC.searchIngredient(code);
        tempE.setDescription(description);
        tempE.setImage(image);
        tempE.setPresentation(presentation);
        tempE.setPrice(price);
        tempE.setName(name);
    }

    /**
     * Method singleton
     * @param id
     * @param password
     * @param name
     * @return 
     */
    public static Administrator getSingletonInstance(int id, String password, 
            String name) {
        if (soyUnico == null) {
            soyUnico = new Administrator(id, password, name);
        } else {
            JOptionPane.showMessageDialog(null,"You cant create another "
                    + name
                    + " because it is already created ");
        }
        return soyUnico;
    }
    
        @Override
    public Administrator clone() {
        try {
            throw new CloneNotSupportedException();
        } catch (CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null,"You cant clone an Admin");
            
        }
        return null;
    }
}
