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
        boolean loginOk=false;
        String type = "";
        PreparedStatement stmt;
        int id = 0;
        ResultSet rs;

        try {

            stmt = conn.prepareStatement("SELECT id FROM members WHERE email = ? AND password = ?");
            stmt.setString(1,username);
            stmt.setString(2,password);

            rs = stmt.executeQuery();
            logger.info("login: " + username);
            if (rs.next()) {
                loginOk=true;
                type="member";
                id= rs.getInt(1);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        if(!loginOk){
            return "";

        }
        return "" + id + "," + type;



    }
}
