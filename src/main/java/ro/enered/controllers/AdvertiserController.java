package ro.enered.controllers;

import ro.enered.entities.Advertiser;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by macbook on 18/12/2016.
 */
public class AdvertiserController extends AbstractController {

    public static void registerAdvertiser(Advertiser m) {
        PreparedStatement stmt;
        try {

            stmt = conn.prepareStatement("INSERT INTO advertisers(email,password) VALUES ?,?");
            stmt.setString(1, m.getEmail());
            stmt.setString(2, m.getPassword());


            stmt.executeUpdate();
            logger.info("registerAdvertiser: " + m.getEmail());

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
    }
}
