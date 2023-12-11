package model;

import java.util.Date;

/**
 *
 * @author allys
 */
public class Reservation {

    private int id;
    private String user_name;
    private Date date;
    private int quantity;
    private int eventID;
    private String name;
    private String description;
    private Date date2;
    private String address, city;
    private int postal_code;
    private double price;
    private String room;
    private String place_id;

    public Reservation() {
    }

    public Reservation(String user_name, Date date, int quantity, int eventID) {
        this.user_name = user_name;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public Reservation(int id, String user_name, Date date, int quantity, int eventID) {
        this.id = id;
        this.user_name = user_name;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public Reservation(int id, String user_name, Date date, int quantity, int eventID, String name, String description,
            Date date2, String address, String city, int postal_code, double price, String room, String place_id) {
        this.id = id;
        this.user_name = user_name;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
        this.name = name;
        this.description = description;
        this.date2 = date2;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.price = price;
        this.room = room;
        this.place_id = place_id;
    }

    public String getUserName() {
        return user_name;
    }

    public void setUserName(String user_name) {
        this.user_name = user_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the date2
     */
    public Date getDate2() {
        return date2;
    }

    /**
     * @param date2 the date2 to set
     */
    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the postal_code
     */
    public int getPostal_code() {
        return postal_code;
    }

    /**
     * @param postal_code the postal_code to set
     */
    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * @return the name3
     */
    public String getPlace_id() {
        return place_id;
    }

    /**
     * @param place_id the place_id to set
     */
    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

}
