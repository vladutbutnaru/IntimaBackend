package ro.enered.controllers;

import ro.enered.entities.Country;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 29/11/2016.
 */
public class CountryController extends AbstractController {
    public static Country getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;
        Country c = new Country();
        try {

            stmt = conn.prepareStatement("SELECT * FROM countries WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCode(rs.getString(2));
                c.setName(rs.getString(3));

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
}
