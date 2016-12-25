package ro.enered.controllers;

import ro.enered.entities.PersonPreference;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 30/11/2016.
 */
public class PersonPreferenceController extends AbstractController {

    public static ArrayList<PersonPreference> getPreferencesForEscort(int id) {
        ArrayList<PersonPreference> preferences = new ArrayList<PersonPreference>();
        PreparedStatement stmt;
        ResultSet rs;

        try {

            stmt = conn.prepareStatement("SELECT * FROM person_has_preference WHERE person_id = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PersonPreference pf = getById(rs.getInt(4));
                pf.setValue(rs.getString(2));
                pf.setId(rs.getInt("person_preference_id"));
                preferences.add(pf);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


        return preferences;

    }

    public static ArrayList<PersonPreference> getAllPreferences() {
        ArrayList<PersonPreference> preferences = new ArrayList<PersonPreference>();
        PreparedStatement stmt;
        ResultSet rs;

        try {

            stmt = conn.prepareStatement("SELECT id FROM person_preferences");


            rs = stmt.executeQuery();

            while (rs.next()) {
                PersonPreference pf = getById(rs.getInt(1));
                pf.setValue(rs.getString(2));
                preferences.add(pf);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


        return preferences;

    }


    public static PersonPreference getById(int id) {
        PersonPreference pf = new PersonPreference();

        PreparedStatement stmt;
        ResultSet rs;

        try {

            stmt = conn.prepareStatement("SELECT * FROM person_preferences WHERE id = ?");

            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pf.setCode(rs.getString(2));
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return pf;


    }

    public static void updateP(int id, String v) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("update person_has_preference set value=? where id=?");
            pst.setString(1, v);
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
