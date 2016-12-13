package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortReviewComment {
    private int id;
    private String content;
    private boolean active;
    private Timestamp createdAt;
    private Escort escort;
    private EscortReview escortReview;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public EscortReview getEscortReview() {
        return escortReview;
    }

    public void setEscortReview(EscortReview escortReview) {
        this.escortReview = escortReview;
    }
}
