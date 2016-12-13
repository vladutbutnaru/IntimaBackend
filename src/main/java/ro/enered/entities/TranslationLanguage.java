package ro.enered.entities;

/**
 * Created by macbook on 29/11/2016.
 */
public class TranslationLanguage {
    private int id;
    private Language language;
    private String translation;
    private String neutral;
    private String male;
    private String female;
    private Translation translationObject;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getNeutral() {
        return neutral;
    }

    public void setNeutral(String neutral) {
        this.neutral = neutral;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getFemale() {
        return female;
    }

    public void setFemale(String female) {
        this.female = female;
    }

    public Translation getTranslationObject() {
        return translationObject;
    }

    public void setTranslationObject(Translation translationObject) {
        this.translationObject = translationObject;
    }
}
