package poo_project;

import Class.Administrator;
import Class.Categories;
import Class.Chef;
import Class.Customer;
import Class.Deliver;
import Class.Dish;
import Class.Food;
import Class.Order;
import Class.Person;
import Class.Seller;
import Screens.Login;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Class.UsersFactory;

/**
 *
 * @author gusta
 */
public class POO_Project {

    public static ArrayList<Person> users;
    public static ArrayList<Categories> listCategories;
    public static ArrayList<Order> listSalesCheck;
    public static ArrayList<Order> listSalesCheckA;

    public static void main(String[] args) {
        users = new ArrayList<Person>();
        listCategories = new ArrayList<Categories>();
        listSalesCheck = new ArrayList<Order>();
        loadInfo();
        Login lg = new Login();
        lg.setVisible(true);
    }
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
    public static void loadInfo() {
        Administrator admin = Administrator.getSingletonInstance(2018, "1", "Nani");
        Chef chef = (Chef) UsersFactory.getPerson("Chef",123, "1", "Adolfo");
        System.out.println(chef.getId());
        Seller seller = (Seller) UsersFactory.getPerson("Seller",321, "1", "Hitler");
        Customer customer = (Customer) UsersFactory.getPerson("Customer",111, "1", "Gusi");
        Deliver del = (Deliver) UsersFactory.getPerson("Deliver",777, "1", "Daniela");
        admin.addCategories("Chinese Food");
        admin.addDish(0, "Arroz Kun Fu Panda", "Arroz chino", 1000, "Mediano", "C:\\Users\\Alvarado\\Desktop\\proyecto\\2condPOO_Project\\src\\Images\\food3.png", "Chinese Food", "Chinese Food");
                 admin.addDrink(01, "Coca Cola", "Coquita", 700, "Mediano", "C:\\Users\\Alvarado\\Desktop\\proyecto\\2condPOO_Project\\src\\Images\\coca.jpg", "Chinese Food");
         admin.addIngredientExtra(02, "Arroz", "Arrocito", 800, "Mediano", "C:\\Users\\Alvarado\\Desktop\\proyecto\\2condPOO_Project\\src\\Images\\arroz.jpg", "Chinese Food");
        Order tempO = new Order(0, "Gusi", 2000, date(), "Ordered");
        tempO.getListDish().add((Dish) searchfood(0));
        tempO.getListDish().add((Dish) searchfood(0));
        listSalesCheck.add(tempO);
        users.add(admin);
        users.add(chef);
        users.add(seller);
        users.add(customer);
        users.add(del);
    }

    public static Person searchUser(int ID) {
        for (int x = 0; x < users.size(); x++) {
            if (users.get(x).getId() == ID) {
                return users.get(x);
            }
        }
        return null;
    }

    public static DateFormat date() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return hourdateFormat;
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

    public static Food searchfood(int code) {
        for (int i = 0; i < listCategories.size(); i++) {
            for (int j = 0; j < listCategories.get(i).getListDish().size(); j++) {
                if (listCategories.get(i).getListDish().get(j).getCode() == code) {
                    return listCategories.get(i).getListDish().get(j);
                }
            }
            for (int j = 0; j < listCategories.get(i).getListDrink().size(); j++) {
                if (listCategories.get(i).getListDrink().get(j).getCode() == code) {
                    return listCategories.get(i).getListDrink().get(j);
                }
            }
            for (int j = 0; j < listCategories.get(i).getListIngredients().size(); j++) {
                if (listCategories.get(i).getListIngredients().get(j).getCode() == code) {
                    return listCategories.get(i).getListIngredients().get(j);
                }
            }
        }
        return null;
    }

}
