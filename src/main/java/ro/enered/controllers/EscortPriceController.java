package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.EscortPhoto;
import ro.enered.entities.EscortPrice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 30/11/2016.
 */
public class EscortPriceController  extends AbstractController{

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
}
