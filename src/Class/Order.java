package Class;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class for the order
 * Date: 10/11/2018.
 * @author Gustavo Méndez and Daniela Alvarado.
 */

public class Order {

    private ArrayList<Ingredients> listExtra;

    private ArrayList<Drink> listDrinks;

    private ArrayList<Dish> listDish;

    private int code;

    private String client;

    private int price;

    private DateFormat requested;
    
    private CookTimer cookTimer;
    
    private DeliverTimer deliverTimer;

    private DateFormat sent;

    private DateFormat received;

    private String state;//Ordered, Asignned, Ready, Delivered

    private Seller seller;

    private Chef chef;

    private Deliver deliver;

    private String deliveryTime;

    public Order(int code, String client, int price, DateFormat requested, String state) {
        this.code = code;
        this.client = client;
        this.price = price;
        this.requested = requested;
        this.state = state;
        this.listExtra = new ArrayList<>();
        this.listDrinks = new ArrayList<>();
        this.listDish = new ArrayList<>();
        this.cookTimer=null;
        this.deliverTimer=null;
    }

    public ArrayList<Ingredients> getListExtra() {
        return listExtra;
    }
    
    /**
     * Method to initialize the cook timer
     */
    public void setCookTimer(){
        this.cookTimer= new CookTimer("00:00");
        this.cookTimer.execute();
    }
    /**
     * Method to initialize the deliver timer
     */
    public void setDeliverTimer(){
        this.deliverTimer= new DeliverTimer("00:00");
        this.deliverTimer.execute();
    }
    /**
     * Method to stop the delivery timer
     */
    public void endDeliverTimer(){
        this.deliverTimer.finish();
    }
    
    /**
     * Method to get the delivery timer
     * @return 
     */
    public String getDeliverTimer(){
        return this.deliverTimer.time;
    }
    
    /**
     * Method to stop the cook timer
     */
    public void endCookTimer(){
        this.cookTimer.finish();
    }
    
    /**
     * Method to get the cook timer
     * @return 
     */
    public String getCookTimer(){
        return this.cookTimer.time;
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

    public void setRequested(DateFormat requested) {
        this.requested = requested;
    }

    public void setSent(DateFormat sent) {
        this.sent = sent;
    }

    public void setReceived(DateFormat received) {
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

    public DateFormat getRequested() {
        return requested;
    }

    public DateFormat getSent() {
        return sent;
    }

    public DateFormat getReceived() {
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

    public DateFormat dateRN() {
        Date date = new Date();
        DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        return hourdateFormat;
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
