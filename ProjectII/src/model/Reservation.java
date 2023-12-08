
package model;

import java.util.Date;

/**
 *
 * @author allys
 */
public class Reservation {
    private int id;
    private String name;
    private Date date;
    private int quantity;
    private int eventID;

    public Reservation() {
    }

    public Reservation(String name, Date date, int quantity, int eventID) {
        this.id = id;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public Reservation(int id, String name, Date date, int quantity, int eventID) {
        this.id = id;
       this.name = name;
        this.date = date;
        this.quantity = quantity;
        this.eventID = eventID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
