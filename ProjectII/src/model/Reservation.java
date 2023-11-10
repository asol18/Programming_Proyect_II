
package model;

import java.util.Date;

/**
 *
 * @author allys
 */
public class Reservation {
    private int id;
    private String userName;
    private Date date;
    private int quantity;
    private int eventID;

    public Reservation() {
    }

    public Reservation(String userName, Date date, int quantity, int eventID) {
        this.userName = userName;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public Reservation(int id, String userName, Date date, int quantity, int eventID) {
        this.id = id;
        this.userName = userName;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
