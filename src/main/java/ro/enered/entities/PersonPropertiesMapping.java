package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class PersonPropertiesMapping {
    private int id;
    private int value;
    private People person;
    private PersonProperty personProperty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public People getPerson() {
        return person;
    }

    public void setPerson(People person) {
        this.person = person;
    }

    public PersonProperty getPersonProperty() {
        return personProperty;
    }

    public void setPersonProperty(PersonProperty personProperty) {
        this.personProperty = personProperty;
    }
}
