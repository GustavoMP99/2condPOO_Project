package Class;

import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<Ingredients> listExtra;

    private ArrayList<Drink> listDrinks;

    private ArrayList<Dish> listDish;

    private ArrayList<Categories> listCategories;

    private int code;

    private String client;

    private int price;

    private Date requested;

    private Date sent;

    private Date received;

    private String state;

    private Seller seller;

    private Chef chef;

    private Deliver deliver;

    private int deliveryTime;

    public Order(int code, String client, int price, Date requested, Date sent, Date received, String state, Seller seller, Chef chef, Deliver deliver, int deliveryTime) {
        this.code = code;
        this.client = client;
        this.price = price;
        this.requested = requested;
        this.sent = sent;
        this.received = null;
        this.state = state;
        this.seller = seller;
        this.chef = chef;
        this.deliver = deliver;
        this.deliveryTime = deliveryTime;
        this.listExtra= new ArrayList<>();
        this.listCategories=new ArrayList<>();
        this.listDrinks=new ArrayList<>();
        this.listDish=new ArrayList<>();
    }  

    public void setCode(int code) {
        this.code = code;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setRequested(Date requested) {
        this.requested = requested;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public void setDeliver(Deliver deliver) {
        this.deliver = deliver;
    }

    public void setDeliveryTime(int deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public int getCode() {
        return code;
    }

    public String getClient() {
        return client;
    }

    public int getPrice() {
        return price;
    }

    public Date getRequested() {
        return requested;
    }

    public Date getSent() {
        return sent;
    }

    public Date getReceived() {
        return received;
    }

    public String getState() {
        return state;
    }

    public Seller getSeller() {
        return seller;
    }

    public Chef getChef() {
        return chef;
    }

    public Deliver getDeliver() {
        return deliver;
    }

    public int getDeliveryTime() {
        return deliveryTime;
    }
    
    
    
}
