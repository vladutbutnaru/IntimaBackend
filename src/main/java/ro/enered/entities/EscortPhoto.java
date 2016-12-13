package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortPhoto {
    private int id;
    private String photo;
    private Timestamp date;
    private int status;
    private boolean profilePhoto;
    private Timestamp createdAt;
    private Escort escort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(boolean profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Escort getEscort() {
        return escort;
    }

    public void setEscort(Escort escort) {
        this.escort = escort;
    }
}
