
package model;

import java.util.Date;

/**
 *
 * @author allys
 */
public class Reservation {
    private int id;
    private int IDUser;
    private Date date;
    private int quantity;
    private int eventID;

    public Reservation() {
    }

    public Reservation(int IDUser, Date date, int quantity, int eventID) {
        this.IDUser = IDUser;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public Reservation(int id, int IDUser, Date date, int quantity, int eventID) {
        this.id = id;
        this.IDUser = IDUser;
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

    public int getIDUser() {
        return IDUser;
    }

    public void setIDUser(int IDUser) {
        this.IDUser = IDUser;
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
