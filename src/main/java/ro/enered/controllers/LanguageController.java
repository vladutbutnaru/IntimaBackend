package ro.enered.controllers;

import ro.enered.entities.Language;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 29/11/2016.
 */
public class LanguageController extends AbstractController {

    public static Language getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;
        Language c = new Language();
        try {

            stmt = conn.prepareStatement("SELECT * FROM languages WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            logger.info("getLanguage: " + id);
            if (rs.next()) {
                c.setId(rs.getInt(1));

                c.setName(rs.getString(2));

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return c;

    }

    public static ArrayList<Language> getLanguagesForString(String languages) {
        ArrayList<Language> languageList = new ArrayList<Language>();
        for (String languageID : languages.split(" ")) {
            Language l = getById(Integer.parseInt(languageID));
            languageList.add(l);
        }
        return languageList;

    }
}
