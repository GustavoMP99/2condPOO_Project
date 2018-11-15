package poo_project;

import Class.Administrator;
import Class.Categories;
import Class.Chef;
import Class.Customer;
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
     
      
}
