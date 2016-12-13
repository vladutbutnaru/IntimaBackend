package ro.enered.controllers;

import ro.enered.entities.City;
import ro.enered.entities.Member;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 01/12/2016.
 */
public class MemberController  extends AbstractController{

public static void registerMember(Member m){
    PreparedStatement stmt;
    try {

        stmt = conn.prepareStatement("INSERT INTO members(email,password,birth_date,username,city,country) VALUES ?,?,?,?,?,?");
       stmt.setString(1,m.getEmail());
        stmt.setString(2,m.getPassword());
        stmt.setTimestamp(3,m.getBirthDate());
        stmt.setString(4,m.getUsername());
        stmt.setInt(5,m.getCity().getId());
        stmt.setInt(6,m.getCountry().getId());

       stmt.executeUpdate();
        logger.info("registerMember: " + m.getEmail());

    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        logger.error(ex.getMessage());

    }
}
    public static Member getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;

       Member m = new Member();
        try {

            stmt = conn.prepareStatement("SELECT * FROM members WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            logger.info("getById: " + id);
            if (rs.next()) {
               m.setUsername(rs.getString(9));


            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return m;

    }
}
