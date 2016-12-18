package ro.enered.controllers;

import ro.enered.entities.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 06/12/2016.
 */
public class AuthController extends AbstractController {

    public static String login(String username, String password){

        String type = "";
        PreparedStatement stmt;
        int id = 0;
        ResultSet rs;
String response ="";
        try {

            stmt = conn.prepareStatement("SELECT id FROM members WHERE email = ? AND password = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            logger.info("login: " + username);
            if (rs.next()) {

                type="member";
                id= rs.getInt(1);
               response = "" + id + "," + type;

            }
            else{
                response = loginEscort(username, password);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return response;



    }
    public static String loginEscort(String username, String password){

        String type = "";
        PreparedStatement stmt;
        int id = 0;
        ResultSet rs;
        String response ="";
        try {

            stmt = conn.prepareStatement("SELECT id FROM escorts WHERE email = ? AND password = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            logger.info("login: " + username);
            if (rs.next()) {

                type="escort";
                id= rs.getInt(1);
                response ="" + id + "," + type;

            }
            else{
                response =loginAgency(username, password);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return response;



    }
    public static String loginAgency(String username, String password){

        String type = "";
        PreparedStatement stmt;
        int id = 0;
        ResultSet rs;
        String response ="";
        try {

            stmt = conn.prepareStatement("SELECT id FROM massage_agency WHERE username = ? AND password = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            logger.info("login: " + username);
            if (rs.next()) {

                type="agency";
                id= rs.getInt(1);
                response = "" + id + "," + type;

            }
            else{
                response = loginAdvertiser(username, password);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return response;



    }

    public static String loginAdvertiser(String username, String password){

        String type = "";
        PreparedStatement stmt;
        int id = 0;
        ResultSet rs;
        String response ="";
        try {

            stmt = conn.prepareStatement("SELECT id FROM advertisers WHERE email = ? AND password = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            logger.info("login: " + username);
            if (rs.next()) {

                type="advertiser";
                id= rs.getInt(1);
                response ="" + id + "," + type;
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return response;


    }
}
