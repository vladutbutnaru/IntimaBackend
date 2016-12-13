package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.EscortPrice;
import ro.enered.entities.EscortSchedule;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 30/11/2016.
 */
public class EscortScheduleController extends AbstractController {

    public static ArrayList<EscortSchedule> getScheduleForEscort(Escort e) {
        PreparedStatement stmt;
        ResultSet rs;

        ArrayList<EscortSchedule> schedules = new ArrayList<EscortSchedule>();
        try {

            stmt = conn.prepareStatement("SELECT * FROM escort_schedule WHERE escort_id = ? ");
            stmt.setInt(1, e.getId());

            rs = stmt.executeQuery();
            logger.info("getScheduleForEscort: " + e.getId());
            while (rs.next()) {
              EscortSchedule es = new EscortSchedule();
                es.setMonday(rs.getString(3));
                es.setTuesday(rs.getString(4));
                es.setWednesday(rs.getString(5));
                es.setThursday(rs.getString(6));
                es.setFriday(rs.getString(7));
                es.setSaturday(rs.getString(8));
                es.setSunday(rs.getString(9));
                schedules.add(es);


            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return schedules;

    }
}
