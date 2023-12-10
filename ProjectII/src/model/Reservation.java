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

}
