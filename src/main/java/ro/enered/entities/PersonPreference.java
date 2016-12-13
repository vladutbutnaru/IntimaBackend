package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class PersonPreference {
    private int id;
    private String code;
    private String group;
    private boolean bdsm;
    private int orientation;
    private boolean quickFilter;
    private Category escortCategory;
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isBdsm() {
        return bdsm;
    }

    public void setBdsm(boolean bdsm) {
        this.bdsm = bdsm;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public boolean isQuickFilter() {
        return quickFilter;
    }

    public void setQuickFilter(boolean quickFilter) {
        this.quickFilter = quickFilter;
    }

    public Category getEscortCategory() {
        return escortCategory;
    }

    public void setEscortCategory(Category escortCategory) {
        this.escortCategory = escortCategory;
    }
}
