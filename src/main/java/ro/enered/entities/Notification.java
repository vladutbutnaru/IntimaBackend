package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 29/11/2016.
 */
public class Notification {
    private int id;
    private String title;
    private String content;
    private Timestamp activeStart;
    private Timestamp activeEnd;
    private boolean hide;
    private Timestamp createdAt;
    private Escort escort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getActiveStart() {
        return activeStart;
    }

    public void setActiveStart(Timestamp activeStart) {
        this.activeStart = activeStart;
    }

    public Timestamp getActiveEnd() {
        return activeEnd;
    }

    public void setActiveEnd(Timestamp activeEnd) {
        this.activeEnd = activeEnd;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
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
