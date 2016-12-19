package ro.enered.controllers;

import ro.enered.entities.Conversation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by dioni on 12/19/2016.
 */
public class ConversationController extends AbstractController {

    public void newConv(String s, int star,Timestamp del_at,int es_id,int mem_id){
        PreparedStatement pst;
        Timestamp current_t = new Timestamp(System.currentTimeMillis());
        try {
            pst=conn.prepareCall("INSERT INTO conversations(subject,star,created_at,deleted_at,escort_id,member_id) VALUES(?,?,?,?,?,?)");
            pst.setString(1,s);
            pst.setInt(2,star);
            pst.setTimestamp(3,current_t);
            pst.setTimestamp(4,del_at);
            pst.setInt(5,es_id);
            pst.setInt(6,mem_id);
            pst.executeQuery();
        }catch (Exception e){

        }
    }
    public void delConv(int id){
        PreparedStatement pst;
        Timestamp current_t = new Timestamp(System.currentTimeMillis());
        try {
            pst= conn.prepareCall("UPDATE conversations SET deleted_at=? WHERE id=?");
            pst.setTimestamp(1,current_t);
            pst.setInt(2, id);
            pst.executeUpdate();
        }catch (Exception e){

        }
    }
    public void starConv(int id){
        PreparedStatement pst;

        try {
            pst= conn.prepareCall("UPDATE conversations SET star=? WHERE id=?");
            pst.setInt(1,1);
            pst.setInt(2, id);
            pst.executeUpdate();
        }catch (Exception e){

        }
    }
    public void unstarConv(int id){
        PreparedStatement pst;

        try {
            pst= conn.prepareCall("UPDATE conversations SET star=? WHERE id=?");
            pst.setInt(1,0);
            pst.setInt(2, id);
            pst.executeUpdate();
        }catch (Exception e){

        }
    }
    public ArrayList<Conversation> getByEsId(int es_id){
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Conversation> list=new ArrayList<Conversation>();
        try {
            pst=conn.prepareStatement("SELECT * FROM conversations WHERE escort_id=?");
            pst.setInt(1,es_id);
            rs=pst.executeQuery();
            while(rs.next()){
                Conversation c=new Conversation();
                c.setId(rs.getInt("id"));
                c.setSubject(rs.getString("subject"));
                boolean star=false;
                if(rs.getInt("star")>0){
                    star=true;
                }
                c.setStar(star);
                c.setCreatedAt(rs.getTimestamp("created_at"));
                c.setDeletedAt(rs.getTimestamp("deleted_at"));
                c.setEscort(EscortController.getById(rs.getInt("escort_id")));
                c.setMember(MemberController.getById(rs.getInt("member_id")));
                list.add(c);

            }
        }catch (Exception e){

        }
        return list;
    }
    public ArrayList<Conversation> getByMemId(int mem_id){
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Conversation> list=new ArrayList<Conversation>();
        try {
            pst=conn.prepareStatement("SELECT * FROM conversations WHERE member_id=?");
            pst.setInt(1,mem_id);
            rs=pst.executeQuery();
            while(rs.next()){
                Conversation c=new Conversation();
                c.setId(rs.getInt("id"));
                c.setSubject(rs.getString("subject"));
                boolean star=false;
                if(rs.getInt("star")>0){
                    star=true;
                }
                c.setStar(star);
                c.setCreatedAt(rs.getTimestamp("created_at"));
                c.setDeletedAt(rs.getTimestamp("deleted_at"));
                c.setEscort(EscortController.getById(rs.getInt("escort_id")));
                c.setMember(MemberController.getById(rs.getInt("member_id")));
                list.add(c);

            }
        }catch (Exception e){

        }
        return list;
    }
    public Conversation getById(int id){
        Conversation c=new Conversation();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=conn.prepareStatement("SELECT * FROM conversations WHERE id=?");
            pst.setInt(1,id);
            rs=pst.executeQuery();
            while(rs.next()){

                c.setId(rs.getInt("id"));
                c.setSubject(rs.getString("subject"));
                boolean star=false;
                if(rs.getInt("star")>0){
                    star=true;
                }
                c.setStar(star);
                c.setCreatedAt(rs.getTimestamp("created_at"));
                c.setDeletedAt(rs.getTimestamp("deleted_at"));
                c.setEscort(EscortController.getById(rs.getInt("escort_id")));
                c.setMember(MemberController.getById(rs.getInt("member_id")));
            }
        }catch (Exception e){

        }
        return c;
    }


}
