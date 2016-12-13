package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.PersonProperty;
import ro.enered.utils.DateHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortController extends AbstractController {
    public static void registerEscort(Escort es){
        PreparedStatement stmt;

        try{
        stmt = conn.prepareStatement("INSERT INTO escorts(email,stage_name,password,city,birth_date,category_id) VALUES ?,?,?,?,?,?");
        stmt.setString(1,es.getEmail());
            stmt.setString(2,es.getStageName());
            stmt.setString(3,es.getPassword());
            stmt.setInt(4,es.getCity().getId());
            stmt.setTimestamp(5,es.getBirthDate());
            stmt.setInt(6,es.getCategory().getId());

            stmt.executeUpdate();



    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        logger.error(ex.getMessage());

    }


    }


    public static ArrayList<Escort> getNewEscorts(int number) {
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Escort> escorts = new ArrayList<Escort>();
        try {

            stmt = conn.prepareStatement("SELECT id, stage_name, city, birth_date FROM escorts WHERE STATUS <> 1 ORDER BY created_at DESC LIMIT " + number);


            rs = stmt.executeQuery();
            logger.info("getNewEscorts: " + number);
            while (rs.next()) {

                Escort e = new Escort();
                e.setId(rs.getInt(1));
//                e.setBdsm(rs.getInt(2) > 0 ? true : false);
//                e.setEmail(rs.getString(3));
//                e.setActivationCode(rs.getString(4));
                e.setStageName(rs.getString(2));
//                e.setStatus(rs.getInt(6));
//                e.setLanguage(LanguageController.getById(rs.getInt(7)));
//                e.setLanguages(LanguageController.getLanguagesForString(rs.getString(8)));
//                e.setAddress(rs.getString(9));
//                e.setSchedule(rs.getString(10));
//                e.setPassword(rs.getString(11));
//                e.setPhoneNumber(rs.getString(12));
//                e.setSlug(rs.getString(13));
//                e.setWebsite(rs.getString(14));
//                e.setArea(rs.getString(15));
                e.setCity(CityController.getById(rs.getInt(3)));
//                e.setGift(rs.getString(17));
//                e.setSuspendedTimeStop(rs.getInt(18) > 0 ? true : false);
//                e.setRecommended(rs.getInt(19) > 0 ? true : false);
//                e.setAlwaysApprovePhotos(rs.getInt(20) > 0 ? true : false);
//                e.setNotifAdmin(rs.getInt(21) > 0 ? true : false);
//                e.setNotifInbox(rs.getInt(22) > 0 ? true : false);
//                e.setNewsletter(rs.getInt(23) > 0 ? true : false);
//                e.setContactByEmail(rs.getInt(24) > 0 ? true : false);
//                e.setBlockComments(rs.getInt(25) > 0 ? true : false);
//                e.setAcceptTerms(rs.getInt(26) > 0 ? true : false);
//                e.setLastLoginIp(rs.getString(27));
                e.setBirthDate(rs.getTimestamp(4));
//                e.setLastLoginDate(rs.getTimestamp(29));
//                e.setSubscriptionStart(rs.getTimestamp(30));
//                e.setSubscriptionEnd(rs.getTimestamp(31));
//                e.setSuspensionStart(rs.getTimestamp(32));
//                e.setSuspensionEnd(rs.getTimestamp(33));
//                e.setCreatedAt(rs.getTimestamp(34));
//                e.setUpdatedAt(rs.getTimestamp(35));
//                e.setDeletedAt(rs.getTimestamp(36));
//                e.setCategory(CategoryController.getById(rs.getInt(37)));
                e.setEscortProfilePicture(EscortPhotoController.getProfilePhotoForEscort(e));
                e.setAge(DateHelper.getAge(new Date(e.getBirthDate().getTime())));
                escorts.add(e);

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return escorts;
    }


    public static Escort getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;
Escort e = new Escort();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escorts WHERE id = ?");
            stmt.setInt(1,id);

            rs = stmt.executeQuery();
            logger.info("getEscort: " + id);
            while (rs.next()) {


                e.setId(rs.getInt(1));
                e.setBdsm(rs.getInt(2) > 0 ? true : false);
                e.setEmail(rs.getString(3));
                e.setActivationCode(rs.getString(4));
                e.setStageName(rs.getString(5));
                e.setStatus(rs.getInt(6));
                e.setLanguage(LanguageController.getById(rs.getInt(7)));
                e.setLanguages(LanguageController.getLanguagesForString(rs.getString(8)));
                e.setAddress(rs.getString(9));
                e.setSchedule(rs.getString(10));
                e.setPassword(rs.getString(11));
                e.setPhoneNumber(rs.getString(12));
                e.setSlug(rs.getString(13));
                e.setWebsite(rs.getString(14));
                e.setArea(rs.getString(15));
                e.setCity(CityController.getById(rs.getInt(16)));
                e.setGift(rs.getString(17));
                e.setSuspendedTimeStop(rs.getInt(18) > 0 ? true : false);
                e.setRecommended(rs.getInt(19) > 0 ? true : false);
                e.setAlwaysApprovePhotos(rs.getInt(20) > 0 ? true : false);
                e.setNotifAdmin(rs.getInt(21) > 0 ? true : false);
                e.setNotifInbox(rs.getInt(22) > 0 ? true : false);
                e.setNewsletter(rs.getInt(23) > 0 ? true : false);
                e.setContactByEmail(rs.getInt(24) > 0 ? true : false);
                e.setBlockComments(rs.getInt(25) > 0 ? true : false);
                e.setAcceptTerms(rs.getInt(26) > 0 ? true : false);
                e.setLastLoginIp(rs.getString(27));
                e.setBirthDate(rs.getTimestamp(28));
                e.setLastLoginDate(rs.getTimestamp(29));
                e.setSubscriptionStart(rs.getTimestamp(30));
                e.setSubscriptionEnd(rs.getTimestamp(31));
                e.setSuspensionStart(rs.getTimestamp(32));
                e.setSuspensionEnd(rs.getTimestamp(33));
                e.setCreatedAt(rs.getTimestamp(34));
                e.setUpdatedAt(rs.getTimestamp(35));
                e.setDeletedAt(rs.getTimestamp(36));
                e.setCategory(CategoryController.getById(rs.getInt(37)));
                e.setEscortProfilePicture(EscortPhotoController.getProfilePhotoForEscort(e));
                e.setAge(DateHelper.getAge(new Date(e.getBirthDate().getTime())));
                e.setPreferences(PersonPreferenceController.getPreferencesForEscort(e.getId()));
                e.setPrices(EscortPriceController.getPricesForEscort(e));
                e.setPhotos(EscortPhotoController.getPhotosForEscort(e));
                e.setSchedules(EscortScheduleController.getScheduleForEscort(e));
                e.setReviews(EscortReviewController.getEscortReviews(e.getId()));

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return e;
    }
    public static ArrayList<Escort> getEscortsWithProperties(ArrayList<PersonProperty>props, int limit){
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Escort> escorts = new ArrayList<Escort>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escorts ORDER BY created_at DESC LIMIT " + limit);


            rs = stmt.executeQuery();
            logger.info("getEscortsWithProperties: " + limit);
            while (rs.next()) {

                Escort e = new Escort();
                e.setId(rs.getInt(1));
                ArrayList<PersonProperty> properties = PersonPropertyController.getPropertiesForEscort(e.getId());
                boolean has;
                boolean ok = true;
                for (PersonProperty p : properties) {
                    has = false;
                    for (PersonProperty p1 : props) {
                        if (p1.getCode().equals(p.getCode())) {
                            has = true;
                            break;
                        }
                        if (has == false) {
                            ok = false;
                            break;

                        }


                    }


                }
                if (ok != false) {
                    e.setBdsm(rs.getInt(2) > 0 ? true : false);
                    e.setEmail(rs.getString(3));
                    e.setActivationCode(rs.getString(4));
                    e.setStageName(rs.getString(2));
                    e.setStatus(rs.getInt(6));
                    e.setLanguage(LanguageController.getById(rs.getInt(7)));
                    e.setLanguages(LanguageController.getLanguagesForString(rs.getString(8)));
                    e.setAddress(rs.getString(9));
                    e.setSchedule(rs.getString(10));
                    e.setPassword(rs.getString(11));
                    e.setPhoneNumber(rs.getString(12));
                    e.setSlug(rs.getString(13));
                    e.setWebsite(rs.getString(14));
                    e.setArea(rs.getString(15));
                    e.setCity(CityController.getById(rs.getInt(16)));
                    e.setGift(rs.getString(17));
                    e.setSuspendedTimeStop(rs.getInt(18) > 0 ? true : false);
                    e.setRecommended(rs.getInt(19) > 0 ? true : false);
                    e.setAlwaysApprovePhotos(rs.getInt(20) > 0 ? true : false);
                    e.setNotifAdmin(rs.getInt(21) > 0 ? true : false);
                    e.setNotifInbox(rs.getInt(22) > 0 ? true : false);
                    e.setNewsletter(rs.getInt(23) > 0 ? true : false);
                    e.setContactByEmail(rs.getInt(24) > 0 ? true : false);
                    e.setBlockComments(rs.getInt(25) > 0 ? true : false);
                    e.setAcceptTerms(rs.getInt(26) > 0 ? true : false);
                    e.setLastLoginIp(rs.getString(27));
                    e.setBirthDate(rs.getTimestamp(28));
                    e.setLastLoginDate(rs.getTimestamp(29));
                    e.setSubscriptionStart(rs.getTimestamp(30));
                    e.setSubscriptionEnd(rs.getTimestamp(31));
                    e.setSuspensionStart(rs.getTimestamp(32));
                    e.setSuspensionEnd(rs.getTimestamp(33));
                    e.setCreatedAt(rs.getTimestamp(34));
                    e.setUpdatedAt(rs.getTimestamp(35));
                    e.setDeletedAt(rs.getTimestamp(36));
                    e.setCategory(CategoryController.getById(rs.getInt(37)));
                    e.setEscortProfilePicture(EscortPhotoController.getProfilePhotoForEscort(e));
                    e.setAge(DateHelper.getAge(new Date(e.getBirthDate().getTime())));
                    e.setPrices(EscortPriceController.getPricesForEscort(e));
                    escorts.add(e);
                }

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return escorts;


    }


    public static ArrayList<Escort> getRecommendedEscorts(int number) {
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Escort> escorts = new ArrayList<Escort>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escorts WHERE recommended = 1 ORDER BY created_at DESC LIMIT " + number);


            rs = stmt.executeQuery();
            logger.info("getRecommendedEscorts: " + number);
            while (rs.next()) {
                Escort e = new Escort();
                e.setId(rs.getInt(1));
                e.setBdsm(rs.getInt(2) > 0 ? true : false);
                e.setEmail(rs.getString(3));
                e.setActivationCode(rs.getString(4));
                e.setStageName(rs.getString(2));
                e.setStatus(rs.getInt(6));
                e.setLanguage(LanguageController.getById(rs.getInt(7)));
                e.setLanguages(LanguageController.getLanguagesForString(rs.getString(8)));
                e.setAddress(rs.getString(9));
                e.setSchedule(rs.getString(10));
                e.setPassword(rs.getString(11));
                e.setPhoneNumber(rs.getString(12));
                e.setSlug(rs.getString(13));
                e.setWebsite(rs.getString(14));
                e.setArea(rs.getString(15));
                e.setCity(CityController.getById(rs.getInt(16)));
                e.setGift(rs.getString(17));
                e.setSuspendedTimeStop(rs.getInt(18) > 0 ? true : false);
                e.setRecommended(rs.getInt(19) > 0 ? true : false);
                e.setAlwaysApprovePhotos(rs.getInt(20) > 0 ? true : false);
                e.setNotifAdmin(rs.getInt(21) > 0 ? true : false);
                e.setNotifInbox(rs.getInt(22) > 0 ? true : false);
                e.setNewsletter(rs.getInt(23) > 0 ? true : false);
                e.setContactByEmail(rs.getInt(24) > 0 ? true : false);
                e.setBlockComments(rs.getInt(25) > 0 ? true : false);
                e.setAcceptTerms(rs.getInt(26) > 0 ? true : false);
                e.setLastLoginIp(rs.getString(27));
                e.setBirthDate(rs.getTimestamp(28));
                e.setLastLoginDate(rs.getTimestamp(29));
                e.setSubscriptionStart(rs.getTimestamp(30));
                e.setSubscriptionEnd(rs.getTimestamp(31));
                e.setSuspensionStart(rs.getTimestamp(32));
                e.setSuspensionEnd(rs.getTimestamp(33));
                e.setCreatedAt(rs.getTimestamp(34));
                e.setUpdatedAt(rs.getTimestamp(35));
                e.setDeletedAt(rs.getTimestamp(36));
                e.setCategory(CategoryController.getById(rs.getInt(37)));
                e.setEscortProfilePicture(EscortPhotoController.getProfilePhotoForEscort(e));
                e.setAge(DateHelper.getAge(new Date(e.getBirthDate().getTime())));
                e.setPrices(EscortPriceController.getPricesForEscort(e));
                escorts.add(e);

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return escorts;
    }
    public static ArrayList<Escort> getEscortsFromEngland(int number) {
        PreparedStatement stmt;
        ResultSet rs;
        ArrayList<Escort> escorts = new ArrayList<Escort>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escorts WHERE STATUS<>1  ORDER BY created_at DESC");


            rs = stmt.executeQuery();
            logger.info("getEscortsFromEngland: " + number);
            while (rs.next()) {
                if(escorts.size()<number) {
                    if (CityController.getById(rs.getInt(16)).getCountry().getId() == 77) {
                        Escort e = new Escort();
                        e.setId(rs.getInt(1));
                e.setBdsm(rs.getInt(2) > 0 ? true : false);
                e.setEmail(rs.getString(3));
                e.setActivationCode(rs.getString(4));
                        e.setStageName(rs.getString(5));
                e.setStatus(rs.getInt(6));
                e.setLanguage(LanguageController.getById(rs.getInt(7)));
                e.setLanguages(LanguageController.getLanguagesForString(rs.getString(8)));
                e.setAddress(rs.getString(9));
                e.setSchedule(rs.getString(10));
                e.setPassword(rs.getString(11));
                e.setPhoneNumber(rs.getString(12));
                e.setSlug(rs.getString(13));
                e.setWebsite(rs.getString(14));
                e.setArea(rs.getString(15));
                        e.setCity(CityController.getById(rs.getInt(16)));
                e.setGift(rs.getString(17));
                e.setSuspendedTimeStop(rs.getInt(18) > 0 ? true : false);
                e.setRecommended(rs.getInt(19) > 0 ? true : false);
                e.setAlwaysApprovePhotos(rs.getInt(20) > 0 ? true : false);
                e.setNotifAdmin(rs.getInt(21) > 0 ? true : false);
                e.setNotifInbox(rs.getInt(22) > 0 ? true : false);
                e.setNewsletter(rs.getInt(23) > 0 ? true : false);
                e.setContactByEmail(rs.getInt(24) > 0 ? true : false);
                e.setBlockComments(rs.getInt(25) > 0 ? true : false);
                e.setAcceptTerms(rs.getInt(26) > 0 ? true : false);
                e.setLastLoginIp(rs.getString(27));
                        e.setBirthDate(rs.getTimestamp(28));
                e.setLastLoginDate(rs.getTimestamp(29));
                e.setSubscriptionStart(rs.getTimestamp(30));
                e.setSubscriptionEnd(rs.getTimestamp(31));
                e.setSuspensionStart(rs.getTimestamp(32));
                e.setSuspensionEnd(rs.getTimestamp(33));
                e.setCreatedAt(rs.getTimestamp(34));
                e.setUpdatedAt(rs.getTimestamp(35));
                e.setDeletedAt(rs.getTimestamp(36));
                e.setCategory(CategoryController.getById(rs.getInt(37)));
                        e.setEscortProfilePicture(EscortPhotoController.getProfilePhotoForEscort(e));
                        e.setAge(DateHelper.getAge(new Date(e.getBirthDate().getTime())));
                        e.setPrices(EscortPriceController.getPricesForEscort(e));

                        escorts.add(e);
                    }
                }
                else
                    break;

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return escorts;
    }


    public static Escort getEscortOfTheMonth(int month) {
        PreparedStatement stmt;
        ResultSet rs;
        Escort e = new Escort();
        try {

            stmt = conn.prepareStatement("SELECT date_start,escort_id FROM escort_of_the");


            rs = stmt.executeQuery();
            logger.info("getEscortOfTheMonth: " + month);
            while (rs.next()) {
                if(rs.getTimestamp(1).getMonth()+1==month){
                    e=getById(rs.getInt(2));

                }

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return e;
    }


}
