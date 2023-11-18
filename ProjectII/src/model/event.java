package model;

import java.util.Date;

/**
 *
 * @author lpper
 */
public class event {

    private int id, room, place_id, postal_code;
    private Date date;
    private String name, description, address, city;
    private double price;

    public event(int id, String name, String description, Date date, String address, String city, int place_id, double price, int room, int postal_code) {
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

    public event(String name, String description, Date date, String address, String city, int postal_code, int place_id, double price, int room) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
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
