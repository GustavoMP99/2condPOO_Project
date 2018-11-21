package Class;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Order {

    private ArrayList<Ingredients> listExtra;

    private ArrayList<Drink> listDrinks;

    private ArrayList<Dish> listDish;

    private int code;

    private String client;

    private int price;

    private String requested;

    private String sent;

    private String received;

    private String state;//Ordered, Asignned, Ready, Delivered

    private Seller seller;

    private Chef chef;

    private Deliver deliver;

    private String deliveryTime;
    
    private int discount;

    public Order(int code, String client, int price, String requested, String state) {
        this.code = code;
        this.client = client;
        this.price = price;
        this.requested = requested;
        this.state = state;
        this.listExtra = new ArrayList<>();
        this.listDrinks = new ArrayList<>();
        this.listDish = new ArrayList<>();
        this.discount=0;
    }

    public ArrayList<Ingredients> getListExtra() {
        return listExtra;
    }

    public ArrayList<Drink> getListDrinks() {
        return listDrinks;
    }

    public ArrayList<Dish> getListDish() {
        return listDish;
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

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public void setSent(String sent) {
        this.sent = sent;
    }

    public void setReceived(String received) {
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

    public void setDeliveryTime(String deliveryTime) {
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

    public String getRequested() {
        return requested;
    }

    public String getSent() {
        return sent;
    }

    public String getReceived() {
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

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    
    public String getHour(DateFormat dateTemp) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dateS = hourdateFormat.format(date);
        String[] hour = dateS.split(" ");
        return hour[0];
    }

    public int getDay(DateFormat dateTemp) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dateS = hourdateFormat.format(date);
        String[] hour = dateS.split(" ");
        String[] day = hour[1].split("/");
        return Integer.parseInt(day[0]);
    }

    public String dateRN() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return hourdateFormat.format(date);
    }

    public int getMounth(DateFormat dateTemp) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dateS = hourdateFormat.format(date);
        String[] hour = dateS.split(" ");
        String[] day = hour[1].split("/");
        return Integer.parseInt(day[1]);
    }

    public int getYear(DateFormat dateTemp) {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        String dateS = hourdateFormat.format(date);
        String[] hour = dateS.split(" ");
        String[] day = hour[1].split("/");
        return Integer.parseInt(day[2]);
    }

}
