package ro.enered.entities;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by macbook on 29/11/2016.
 */
public class Escort {
    private int id;
    private boolean bdsm;
    private String email;
    private String activationCode;
    private String stageName;
    private int status;
    private Language language;
    private ArrayList<Language> languages;
    private String address;
    private String schedule;
    private String password;
    private String phoneNumber;
    private String slug;
    private String website;
    private String area;
    private int age;
    private ArrayList<PersonProperty> properties;
    private City city;
    private String gift;
    private boolean suspendedTimeStop;
    private boolean recommended;
    private boolean alwaysApprovePhotos;
    private boolean notifAdmin;
    private boolean notifInbox;
    private boolean newsletter;
    private boolean contactByEmail;
    private boolean blockComments;
    private boolean acceptTerms;
    private String lastLoginIp;
    private Timestamp birthDate;
    private Timestamp lastLoginDate;
    private Timestamp subscriptionStart;
    private Timestamp subscriptionEnd;
    private Timestamp suspensionStart;
    private Timestamp suspensionEnd;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;
    private Category category;
    private EscortPhoto escortProfilePicture;
    private ArrayList<EscortPhoto> photos;
    private ArrayList<PersonPreference> preferences;
    private ArrayList<EscortPrice> prices;
    private ArrayList<EscortSchedule> schedules;
    private ArrayList<EscortReview> reviews;
    private ArrayList<PersonProperty> default_properties;
    private String greutate;
    private String dimensiune;
    private String moneda;

    public String getGreutate() {
        return greutate;
    }

    public void setGreutate(String greutate) {
        this.greutate = greutate;
    }

    public String getDimensiune() {
        return dimensiune;
    }

    public void setDimensiune(String dimensiune) {
        this.dimensiune = dimensiune;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public ArrayList<PersonProperty> getDefault_properties() {
        return default_properties;
    }

    public void setDefault_properties(ArrayList<PersonProperty> default_properties) {
        this.default_properties = default_properties;
    }

    public ArrayList<EscortReview> getReviews() {
        return reviews;
    }

    public void setReviews(ArrayList<EscortReview> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<EscortSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<EscortSchedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<EscortPrice> getPrices() {
        return prices;
    }

    public void setPrices(ArrayList<EscortPrice> prices) {
        this.prices = prices;
    }

    public ArrayList<PersonPreference> getPreferences() {
        return preferences;
    }

    public void setPreferences(ArrayList<PersonPreference> preferences) {
        this.preferences = preferences;
    }

    public ArrayList<EscortPhoto> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<EscortPhoto> photos) {
        this.photos = photos;
    }

    public ArrayList<PersonProperty> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<PersonProperty> properties) {
        this.properties = properties;
    }

    public EscortPhoto getEscortProfilePicture() {
        return escortProfilePicture;
    }

    public void setEscortProfilePicture(EscortPhoto escortProfilePicture) {
        this.escortProfilePicture = escortProfilePicture;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isBdsm() {
        return bdsm;
    }

    public void setBdsm(boolean bdsm) {
        this.bdsm = bdsm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public ArrayList<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<Language> languages) {
        this.languages = languages;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public boolean isSuspendedTimeStop() {
        return suspendedTimeStop;
    }

    public void setSuspendedTimeStop(boolean suspendedTimeStop) {
        this.suspendedTimeStop = suspendedTimeStop;
    }

    public boolean isRecommended() {
        return recommended;
    }

    public void setRecommended(boolean recommended) {
        this.recommended = recommended;
    }

    public boolean isAlwaysApprovePhotos() {
        return alwaysApprovePhotos;
    }

    public void setAlwaysApprovePhotos(boolean alwaysApprovePhotos) {
        this.alwaysApprovePhotos = alwaysApprovePhotos;
    }

    public boolean isNotifAdmin() {
        return notifAdmin;
    }

    public void setNotifAdmin(boolean notifAdmin) {
        this.notifAdmin = notifAdmin;
    }

    public boolean isNotifInbox() {
        return notifInbox;
    }

    public void setNotifInbox(boolean notifInbox) {
        this.notifInbox = notifInbox;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isContactByEmail() {
        return contactByEmail;
    }

    public void setContactByEmail(boolean contactByEmail) {
        this.contactByEmail = contactByEmail;
    }

    public boolean isBlockComments() {
        return blockComments;
    }

    public void setBlockComments(boolean blockComments) {
        this.blockComments = blockComments;
    }

    public boolean isAcceptTerms() {
        return acceptTerms;
    }

    public void setAcceptTerms(boolean acceptTerms) {
        this.acceptTerms = acceptTerms;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Timestamp getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Timestamp lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Timestamp getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(Timestamp subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public Timestamp getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(Timestamp subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    public Timestamp getSuspensionStart() {
        return suspensionStart;
    }

    public void setSuspensionStart(Timestamp suspensionStart) {
        this.suspensionStart = suspensionStart;
    }

    public Timestamp getSuspensionEnd() {
        return suspensionEnd;
    }

    public void setSuspensionEnd(Timestamp suspensionEnd) {
        this.suspensionEnd = suspensionEnd;
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

    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Timestamp deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
