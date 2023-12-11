package model;

import java.util.Date;

/**
 *
 * @author lpper
 */
public class Event {

    private int id, place_id, postal_code;
    private String room;
    private Date date;
    private String name, description, address, city;
    private double price;
    
    public Event(){
    
    }

    public Event(int id, String name, String description, Date date, String address, String city, int place_id, double price,
            String room, int postal_code) {
        this.id = id;
        this.room = room;
        this.place_id = place_id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.price = price;
        this.postal_code = postal_code;
        this.date = date;
    }

    public Event(String name, String description, Date date, String address, String city, int postal_code, int place_id, double price, String room) {
        this.room = room;
        this.place_id = place_id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.price = price;
        this.postal_code = postal_code;
        this.date = date;
    }

    public Event(int id, String name, String description, Date date, String address, String city,double price, String room) {
        this.id = id;
        this.room = room;
        this.date = date;
        this.name = name;
        this.description = description;
        this.address = address;
        this.city = city;
        this.price = price;
    }

    public Event(String name) {
        this.name = name;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getPlace_id() {
        return place_id;
    }

    public void setPlace_id(int place_id) {
        this.place_id = place_id;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
