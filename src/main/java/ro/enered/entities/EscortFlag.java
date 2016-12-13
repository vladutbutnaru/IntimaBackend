package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortFlag {

    private int id;
    private String code;
    private boolean filter;
    private boolean watermark;
    private boolean isQuickFilter;

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

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public boolean isWatermark() {
        return watermark;
    }

    public void setWatermark(boolean watermark) {
        this.watermark = watermark;
    }

    public boolean isQuickFilter() {
        return isQuickFilter;
    }

    public void setQuickFilter(boolean quickFilter) {
        isQuickFilter = quickFilter;
    }
}
