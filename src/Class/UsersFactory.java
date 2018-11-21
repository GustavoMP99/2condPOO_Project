package Class;

/**
 * Class for the UserFactory
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */
public class UsersFactory {
        public static Person getPerson(String type,int id, String pass, String name){
            switch (type) {
                case "Chef":
                    return new Chef(id, pass, name);
                case "Seller":
                    return new Seller(id, pass, name);
                case "Customer":
                    return new Customer(id, pass, name);
                case "Deliver":
                    return new Deliver(id, pass, name);
                default:
                    return null;
            }
    }
}
