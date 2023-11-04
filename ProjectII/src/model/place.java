package model;

/**
 *
 * @author deivis
 */
public class place {

    private int id;
    private String name, address, city;
    private int postal_code, latitude, longitude;
    private String tripAdvisor_link;

    public place(int id, String name, String address, String city, int postal_code, int latitude, int longitude, String tripAdvisor_link) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripAdvisor_link = tripAdvisor_link;
    }

    public place(String name, String address, String city, int postal_code, int latitude, int longitude, String tripAdvisor_link) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.postal_code = postal_code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tripAdvisor_link = tripAdvisor_link;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the latitude
     */
    public int getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the longitude
     */
    public int getLongitude() {
        return longitude;
    }

    /**
     * @param longitude the longitude to set
     */
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    /**
     * @return the tripAdvisor_link
     */
    public String getTripAdvisor_link() {
        return tripAdvisor_link;
    }

    /**
     * @param tripAdvisor_link the tripAdvisor_link to set
     */
    public void setTripAdvisor_link(String tripAdvisor_link) {
        this.tripAdvisor_link = tripAdvisor_link;
    }

}
