package ro.enered.controllers;

import ro.enered.entities.Escort;
import ro.enered.entities.People;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by dioni on 12/19/2016.
 */
public class PeopleController extends AbstractController{
    public void addP(int o, int r, int g, Timestamp c,Escort e){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("insert into people(orientation,role,gender,created_at,escort_id) VALUES (?,?,?,?,?)");
            pst.setInt(1 ,o);
            pst.setInt(2,r);
            pst.setInt(3,g);
            pst.setTimestamp(4,c);
            pst.setInt(5,e.getId());
            pst.executeUpdate();

        }catch (Exception e1){

        }

    }
    public void editP(int id,int o, int r, int g, Timestamp c,Escort e){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("UPDATE people SET orientation=?,role=?,gender=?,created_at=?,escort_id=? WHERE id=?");
            pst.setInt(1 ,o);
            pst.setInt(2,r);
            pst.setInt(3,g);
            pst.setTimestamp(4,c);
            pst.setInt(5,e.getId());
            pst.setInt(6,id);
            pst.executeUpdate();

        }catch (Exception e1){

        }
    }
    public void delP(int id){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("DELETE FROM people WHERE id=?");
           pst.setInt(1,id);
            pst.executeUpdate();

        }catch (Exception e1){

        }
    }
    public static People getById(int id){
        People p=new People();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=conn.prepareStatement("SELECT * FROM people WHERE id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){
                p.setRole(rs.getInt("role"));
                p.setCreatedAt(rs.getTimestamp("created_at"));
                p.setOrientation(rs.getInt("orientation"));
                p.setGender(rs.getInt("gender"));
                p.setEscort(EscortController.getById(rs.getInt("escort_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
