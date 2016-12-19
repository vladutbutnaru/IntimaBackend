package ro.enered.controllers;

import ro.enered.entities.People;
import ro.enered.entities.PersonPropertiesMapping;
import ro.enered.entities.PersonProperty;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by dioni on 12/19/2016.
 */
public class PersonPropertiesMappingController extends AbstractController{
    public void addPP(String v, People p, PersonProperty pp){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("INSERT INTO person_has_properties(field_value,person_id,person_property_id) VALUES (?,?,?)");
            pst.setString(1,v);
            pst.setInt(2,p.getId());
            pst.setInt(3,p.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void changeV(String v,int id){
    PreparedStatement pst;

        try{
        pst=conn.prepareStatement("UPDATE person_has_properties SET field_value=? WHERE id=?");
        pst.setString(1,v);
        pst.setInt(2,id);
        pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public ArrayList<PersonPropertiesMapping> getByPID(int id){
        ArrayList<PersonPropertiesMapping> list=new ArrayList<PersonPropertiesMapping>();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=conn.prepareStatement("SELECT * FROM person_has_properties WHERE id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                PersonPropertiesMapping pp=new PersonPropertiesMapping();
                pp.setId(rs.getInt("id"));
                pp.setPerson(PeopleController.getById(rs.getInt("person_id")));
                pp.setPersonProperty(PersonPropertyController.getById(rs.getInt("person_property_id")));
                list.add(pp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }





}
