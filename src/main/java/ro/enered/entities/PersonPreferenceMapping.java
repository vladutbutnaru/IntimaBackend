package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class PersonPreferenceMapping {
    private int id;
    private int value;
    private People person;
    private PersonPreference personPreference;

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

    public PersonPreference getPersonPreference() {
        return personPreference;
    }

    public void setPersonPreference(PersonPreference personPreference) {
        this.personPreference = personPreference;
    }
}
