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

            stmt = conn.prepareStatement("SELECT field_value,person_property_id,id FROM person_has_properties WHERE person_id = ?");

            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            while (rs.next()) {
                PersonProperty pr;
                pr = getById(rs.getInt(2));
                pr.setValue(rs.getString(1));
                pr.setId(rs.getInt("id"));
                pr.setPpid(rs.getInt("person_property_id"));

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
    public static ArrayList<PersonProperty> getDefaultValues(){
        ArrayList<PersonProperty> list=new ArrayList<PersonProperty>();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=conn.prepareStatement("SELECT * FROM person_properties");
            rs=pst.executeQuery();
            while(rs.next()){
                PersonProperty pp=new PersonProperty();
                pp.setId(rs.getInt(1));
                pp.setCode(rs.getString(2));
                pp.setCategory(rs.getInt(3));
                boolean multi=false;
                if(rs.getInt(4)>0){
                    multi=true;
                }
                pp.setMultipleSelect(multi);
                pp.setSelectableValues(rs.getString(5));
                boolean quick=false;
                if(rs.getInt(6)>0){
                    quick=true;
                }
                pp.setQuickFilter(quick);
                pp.setEscortCategory(CategoryController.getById(rs.getInt(7)));
                list.add(pp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
public static ArrayList<PersonProperty> getByCategory(int category, int escortCategory){
    ArrayList<PersonProperty> properties = new ArrayList<PersonProperty>();
    PreparedStatement stmt;
    ResultSet rs;

    try {

        stmt = conn.prepareStatement("SELECT * FROM person_properties");

        rs = stmt.executeQuery();

        while (rs.next()) {
            PersonProperty pr;
            pr = getById(rs.getInt(1));
            if(pr.getCategory() == category) {
                pr.setNumOfEscorts(getNumberOfEscortsWithProperty(escortCategory, rs.getInt(1)));
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
public static int getNumberOfEscortsWithProperty(int escortCategory, int propertyID){
    //1 for girls, 2 for lesbians, 3 men, 4 gays, 5 ts, 6 tv, 7 couples, 8 bdsm
    int numOfEscorts =0;
    PreparedStatement stmt;
    ResultSet rs;
    PersonProperty pp = new PersonProperty();

    try{
        ArrayList<Escort> escorts = new ArrayList<Escort>();
      switch(escortCategory){
          case 1:
              escorts=EscortController.getFemaleEscorts(1000);
              break;
          case 2:
              escorts =EscortController.getLesbianEscorts(1000);
              break;
          case 3:
              escorts = EscortController.getMenEscorts(1000);
              break;
          case 4:
              escorts = EscortController.getGayEscorts(1000);
              break;
          case 5:
              escorts=EscortController.getTSEscorts(1000);
              break;
          case 6:
              escorts=EscortController.getTVEscorts(1000);
              break;
          case 7:
              escorts = EscortController.getCoupleEscorts(1000);
              break;



      }
        for(Escort e : escorts) {
            stmt = conn.prepareStatement("SELECT id FROM person_has_properties WHERE  person_id = ? AND person_property_id = ?");

            stmt.setInt(1, e.getId());
            stmt.setInt(2, propertyID);
            rs = stmt.executeQuery();

            while (rs.next()) {
                numOfEscorts++;

            }
        }

    }
    catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
        logger.error(ex.getMessage());

    }

    return numOfEscorts;




}

    public static PersonProperty getById(int id){
        PreparedStatement stmt;
        ResultSet rs;
        PersonProperty pp = new PersonProperty();
        try{
            stmt = conn.prepareStatement("SELECT * FROM person_properties WHERE id = ?");

            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                pp.setCategory(rs.getInt(3));
               pp.setCode(rs.getString(2));
                pp.setSelectableValues(rs.getString(5));
                boolean multi=false;
                if(rs.getInt(4)==1){
                    multi=true;
                }

                pp.setMultipleSelect(multi);
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

    public static PersonProperty getByCode(String code){
        PreparedStatement stmt;
        ResultSet rs;
        PersonProperty pp = new PersonProperty();
        try{
            stmt = conn.prepareStatement("SELECT * FROM person_properties WHERE code = ?");

            stmt.setString(1,code);
            rs = stmt.executeQuery();

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
