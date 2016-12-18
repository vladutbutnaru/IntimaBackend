package ro.enered.controllers;

import ro.enered.entities.EscortPhoto;
import ro.enered.entities.EscortReview;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 01/12/2016.
 */
public class EscortReviewController extends AbstractController {

    public static ArrayList<EscortReview> getEscortReviews(int id){
        ArrayList<EscortReview> reviews = new ArrayList<EscortReview>();
        PreparedStatement stmt;
        ResultSet rs;


        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_reviews WHERE escort_id = ? AND active=1");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();

            while (rs.next()) {
               EscortReview er = new EscortReview();
              er.setContent(rs.getString(2));
                er.setCreatedAt(rs.getTimestamp(4));
                er.setMember(MemberController.getById(rs.getInt(6)));
                er.setMeetingDate(rs.getTimestamp(7));
                er.setDuration(rs.getInt(8));
                er.setCity(CityController.getById(rs.getInt(9)));
                er.setLook(rs.getInt(10));
                er.setHygiene(rs.getInt(11));
                er.setServices(rs.getInt(12));
                er.setCommunication(rs.getInt(13));
                er.setPhoto(rs.getInt(14));
                er.setRating(rs.getInt(15));
                reviews.add(er);

            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return reviews;





    }
}
