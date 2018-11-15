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

    public void addDish(int code, String name, String description, int price, String presentation, String image, String ingredients, String categorie) {
        Categories tempC = searchCategorie(categorie);
        if (tempC.getListDish()==null) {
            Dish newDish = new Dish(code, name, description, price, presentation, image, ingredients);
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
        Dish newDish = new Dish(code, name, description, price, presentation, image, ingredients);
        tempC.getListDish().add(newDish);
        JOptionPane.showMessageDialog(null, "It was created correctly");
    }

    public static Categories searchCategorie(String name) {
        for (int x = 0; x < listCategories.size(); x++) {
            if (listCategories.get(x).getName().equals(name)) {
                return listCategories.get(x);
            }
        }
        return null;
    }
}
