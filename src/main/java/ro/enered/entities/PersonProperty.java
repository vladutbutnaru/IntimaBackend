package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class PersonProperty {
    private int id;
    private String code;
    private int category;
    private boolean multipleSelect;
    private String selectableValues;
    private boolean quickFilter;
    private Category escortCategory;
    private String value;
    private int numOfEscorts;

    public int getNumOfEscorts() {
        return numOfEscorts;
    }

    public void setNumOfEscorts(int numOfEscorts) {
        this.numOfEscorts = numOfEscorts;
    }

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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean isMultipleSelect() {
        return multipleSelect;
    }

    public void setMultipleSelect(boolean multipleSelect) {
        this.multipleSelect = multipleSelect;
    }

    public String getSelectableValues() {
        return selectableValues;
    }

    public void setSelectableValues(String selectableValues) {
        this.selectableValues = selectableValues;
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
