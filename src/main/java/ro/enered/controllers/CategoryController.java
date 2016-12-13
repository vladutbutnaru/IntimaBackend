package ro.enered.controllers;

import ro.enered.entities.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 29/11/2016.
 */
public class CategoryController extends AbstractController {
    public static Category getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;
        Category c = new Category();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_categories WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            logger.info("getCategories: " + id);
            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setCode(rs.getString(2));
                c.setGender(rs.getInt(3));
                c.setOrder(rs.getInt(4));

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
