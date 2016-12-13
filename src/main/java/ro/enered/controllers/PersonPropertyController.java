package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.PersonProperty;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by macbook on 30/11/2016.
 */
public class PersonPropertyController  extends AbstractController {

    public static ArrayList<PersonProperty>  getPropertiesForEscort(int id){
        ArrayList<PersonProperty> properties = new ArrayList<PersonProperty>();
        PreparedStatement stmt;
        ResultSet rs;

        try {

            stmt = conn.prepareStatement("SELECT field_value,person_property_id FROM person_has_properties WHERE person_id = ?");

            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            logger.info("getPropertiesForEscort: " + id);
            while (rs.next()) {
                PersonProperty pr;
                pr = getById(rs.getInt(2));
                pr.setValue(rs.getString(1));
                properties.add(pr);
            }

    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        logger.error(ex.getMessage());

    }


        return properties;

    }
public static ArrayList<PersonProperty> getByCategory(int category){
    ArrayList<PersonProperty> properties = new ArrayList<PersonProperty>();
    PreparedStatement stmt;
    ResultSet rs;

    try {

        stmt = conn.prepareStatement("SELECT * FROM person_properties");

        rs = stmt.executeQuery();
        logger.info("getByCategory: " + category);
        while (rs.next()) {
            PersonProperty pr;
            pr = getById(rs.getInt(1));
            if(pr.getCategory() == category) {

                properties.add(pr);
            }
        }

    } catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        logger.error(ex.getMessage());

    }


    return properties;



}
    public static PersonProperty getById(int id){
        PreparedStatement stmt;
        ResultSet rs;
        PersonProperty pp = new PersonProperty();
        try{
            stmt = conn.prepareStatement("SELECT * FROM person_properties WHERE id = ?");

            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            logger.info("getById: " + id);
            if (rs.next()) {
                pp.setCategory(rs.getInt(3));
               pp.setCode(rs.getString(2));

            }


        }
        catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return pp;


    }

}
