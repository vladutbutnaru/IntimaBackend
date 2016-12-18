package ro.enered.controllers;

import ro.enered.entities.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 29/11/2016.
 */
public class CityController extends AbstractController {
    public static City getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;

        City c = new City();
        try {

            stmt = conn.prepareStatement("SELECT * FROM cities WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCity(rs.getString(2));
                c.setCountry(CountryController.getById(rs.getInt(3)));

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
    public static City getByName(String name){
        PreparedStatement stmt;
        ResultSet rs;

        City c = new City();
        try {

            stmt = conn.prepareStatement("SELECT * FROM cities WHERE UPPER(city) LIKE UPPER (?)");
            stmt.setString(1, name);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));

                c.setCountry(CountryController.getById(rs.getInt(3)));

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
