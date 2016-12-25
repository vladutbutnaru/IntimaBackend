package ro.enered.controllers;

import ro.enered.entities.Administrator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 22/12/2016.
 */
public class AdminController extends AbstractController {
    public static Administrator getById(int id) {
        Administrator admin = new Administrator();
        PreparedStatement stmt;

        ResultSet rs;
        try {

            stmt = conn.prepareStatement("SELECT * FROM administrators WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                admin.setId(rs.getInt(1));
                admin.setUsername(rs.getString(2));
                admin.setName(rs.getString(3));
                admin.setEmail(rs.getString(4));
                admin.setPassword(rs.getString(5));


            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return admin;

    }

    public static Administrator login(String user, String pass) {
        Administrator admin = new Administrator();
        PreparedStatement stmt;
        System.out.println(user + " " + pass);
        ResultSet rs;
        try {

            stmt = conn.prepareStatement("SELECT * FROM administrators WHERE email = ? AND password = ?");
            stmt.setString(1, user);
            stmt.setString(2, pass);

            rs = stmt.executeQuery();

            if (rs.next()) {
                admin.setId(rs.getInt(1));
                System.out.println(admin.getId());


            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return admin;

    }

}
