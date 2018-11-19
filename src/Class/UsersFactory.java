/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author gusta
 */
public class UsersFactory {
        public static Person getPerson(String type,int id, String pass, String name){
        if(type.equals("Chef")){
            return new Chef(id, pass, name);
        }
        else if(type.equals("Seller")){
            return new Seller(id, pass, name);
        }
        else if(type.equals("Customer")){
            return new Customer(id, pass, name);
        }
        else if(type.equals("Deliver")){
            return new Deliver(id, pass, name);
        }
        else{
            return null;
        }
    }
}
