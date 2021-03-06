package Model;

public class Entry {
    private int id;
    private int userid;
    private String address;
    private String city;
    private String country;
    
    public Entry(int id, int userid, String address, String city, String country){
        this.id = id;
        this.userid = userid;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public int getUserid() {
        return userid;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    
}
