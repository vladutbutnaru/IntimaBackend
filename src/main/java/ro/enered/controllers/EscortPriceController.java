package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.EscortPrice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 30/11/2016.
 */
public class EscortPriceController extends AbstractController {

    public static ArrayList<EscortPrice> getPricesForEscort(Escort e) {
        PreparedStatement stmt;
        ResultSet rs;

        ArrayList<EscortPrice> prices = new ArrayList<EscortPrice>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_prices WHERE escort_id = ? ");
            stmt.setInt(1, e.getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                EscortPrice ep = new EscortPrice();
                ep.setDuration(rs.getString(3));
                ep.setLocation(rs.getInt(2));
                ep.setPrice(rs.getInt(4));
                ep.setId(rs.getInt("id"));
                prices.add(ep);


            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return prices;

    }

    public static void updateP(int id, String v) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("update escort_prices set price=? where id=?");
            pst.setInt(1, Integer.parseInt(v));
            pst.setInt(2, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
