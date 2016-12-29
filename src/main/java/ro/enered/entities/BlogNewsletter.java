package ro.enered.entities;

/**
 * Created by macbook on 29/12/2016.
 */
public class BlogNewsletter {
    private int id;
    private String email;
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
