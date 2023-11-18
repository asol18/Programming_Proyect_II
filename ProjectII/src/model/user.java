package model;

import java.util.Date;

/**
 *
 * @author lpper
 */
public class user {

    private int id, ID_Number, phone_number, rol_id;
    private String name, last_name, email, password;
    private Date birth_date;

    public user() {
    }

    public user(int ID_Number, String name, String last_name, Date birth_date, String email, int phone_number, String password, int rol_id) {
        this.ID_Number = ID_Number;
        this.phone_number = phone_number;
        this.rol_id = rol_id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
    }

    public user(int id, int ID_Number, String name, String last_name, Date birth_date, String email, int phone_number, String password, int rol_id) {
        this.ID_Number = ID_Number;
        this.phone_number = phone_number;
        this.rol_id = rol_id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.birth_date = birth_date;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getID_Number() {
        return ID_Number;
    }

    public void setID_Number(int ID_Number) {
        this.ID_Number = ID_Number;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }

    public int getRol_id() {
        return rol_id;
    }

    public void setRol_id(int rol_id) {
        this.rol_id = rol_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

}
