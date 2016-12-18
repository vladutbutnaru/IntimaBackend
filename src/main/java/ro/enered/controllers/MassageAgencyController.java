package ro.enered.controllers;

import ro.enered.entities.MassageAgency;
import ro.enered.entities.Member;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by macbook on 18/12/2016.
 */
public class MassageAgencyController extends AbstractController {

    public static void registerAgency(MassageAgency m){
        PreparedStatement stmt;
        try {

            stmt = conn.prepareStatement("INSERT INTO massage_agency(email,username,password,city) VALUES ?,?,?,?");
            stmt.setString(1,m.getEmail());
            stmt.setString(3,m.getPassword());
            stmt.setString(2,m.getUser());
            stmt.setInt(4,m.getCity().getId());


            stmt.executeUpdate();


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
    }

}
