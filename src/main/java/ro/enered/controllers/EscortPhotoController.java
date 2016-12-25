package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.EscortPhoto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 29/11/2016.
 */
public class EscortPhotoController extends AbstractController {
    public static EscortPhoto getById(int id) {
        PreparedStatement stmt;
        ResultSet rs;

        EscortPhoto c = new EscortPhoto();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_photos WHERE id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setPhoto(rs.getString(2));
                c.setDate(rs.getTimestamp(3));
                c.setStatus(rs.getInt(4));
                c.setProfilePhoto(rs.getInt(5) > 0 ? true : false);
                c.setCreatedAt(rs.getTimestamp(6));
                c.setEscort(null);


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

    public static EscortPhoto getProfilePhotoForEscort(Escort e) {
        PreparedStatement stmt;
        ResultSet rs;

        EscortPhoto c = new EscortPhoto();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_photos WHERE escort_id = ? AND profile_photo=1");
            stmt.setInt(1, e.getId());

            rs = stmt.executeQuery();

            if (rs.next()) {
                c.setId(rs.getInt(1));
                c.setPhoto(rs.getString(2));
                c.setDate(rs.getTimestamp(3));
                c.setStatus(rs.getInt(4));
                c.setProfilePhoto(rs.getInt(5) > 0 ? true : false);
                c.setCreatedAt(rs.getTimestamp(6));
                c.setEscort(null);


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


    public static ArrayList<EscortPhoto> getPhotosForEscort(Escort e) {
        PreparedStatement stmt;
        ResultSet rs;

        ArrayList<EscortPhoto> photos = new ArrayList<EscortPhoto>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_photos WHERE escort_id = ? AND profile_photo=1");
            stmt.setInt(1, e.getId());

            rs = stmt.executeQuery();

            while (rs.next()) {
                EscortPhoto c = new EscortPhoto();
                c.setId(rs.getInt(1));
                c.setPhoto(rs.getString(2));
                c.setDate(rs.getTimestamp(3));
                c.setStatus(rs.getInt(4));
                c.setProfilePhoto(rs.getInt(5) > 0 ? true : false);
                c.setCreatedAt(rs.getTimestamp(6));
                c.setEscort(null);
                photos.add(c);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return photos;

    }


}
