package poo_project;

import Class.Administrator;
import Class.Categories;
import Class.Chef;
import Class.Customer;
import Class.Food;
import Class.Person;
import Class.Seller;
import Screens.Login;
import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class POO_Project {
    
  public static ArrayList<Person> users;
  public static ArrayList<Categories> listCategories;
   
    public static void main(String[] args) {
      users = new ArrayList<Person>();
      listCategories= new ArrayList<Categories>();
      loadInfo();
        Login lg= new Login();
       lg.setVisible(true);
    }
    
    public static void loadInfo(){
         Administrator admin = new Administrator(2018, "1", "Nani");
         Chef chef= new Chef(123, "1","Adolfo");
         Seller seller= new Seller(321, "1","Hitler");
         Customer customer= new Customer(111,"1","Gusi");
         admin.addCategories("Animu food");
         admin.addDish(0, "Sho", "Sea necia", 1000, "Mediano", "C:\\Users\\Alvarado\\Desktop\\proyecto\\2condPOO_Project\\src\\Images\\food3.png", "Holi", "Animu food");
         users.add(admin);
         users.add(chef);
         users.add(seller);
         users.add(customer);
    }
    
     public static Person searchUser(int ID){
        for(int x = 0; x < users.size(); x++){
            if(users.get(x).getId()==ID)
                return users.get(x);
        }
        return null;
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
    
    public static  Food searchfood(int code){
        for (int i = 0; i < listCategories.size(); i++) {
            for (int j = 0; j < listCategories.get(i).getListDish().size(); j++) {
                if (listCategories.get(i).getListDish().get(j).getCode()==code) {
                    return listCategories.get(i).getListDish().get(j);
                }
            }
            for (int j = 0; j < listCategories.get(i).getListDrink().size(); j++) {
                if (listCategories.get(i).getListDrink().get(j).getCode()==code) {
                    return listCategories.get(i).getListDrink().get(j);
                }
            }
            for (int j = 0; j < listCategories.get(i).getListIngredients().size(); j++) {
                if (listCategories.get(i).getListIngredients().get(j).getCode()==code) {
                    return listCategories.get(i).getListIngredients().get(j);
                }
            }   
        }
        return null;
    }
      
}
