package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 29/11/2016.
 */
public class FreshFluxNotification {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Escort escort;
    private Member member;
    private FreshFlux freshFlux;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Escort getEscort() {
        return escort;
    }

    public void setEscort(Escort escort) {
        this.escort = escort;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public FreshFlux getFreshFlux() {
        return freshFlux;
    }

    public void setFreshFlux(FreshFlux freshFlux) {
        this.freshFlux = freshFlux;
    }
}
