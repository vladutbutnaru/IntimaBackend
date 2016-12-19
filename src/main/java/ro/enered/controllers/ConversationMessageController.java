package ro.enered.controllers;

import ro.enered.entities.Conversation;
import ro.enered.entities.ConversationMessage;

import javax.xml.transform.Result;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Created by dioni on 12/19/2016.
 */
public class ConversationMessageController extends AbstractController {

    public void newMes(String m, Conversation c){
        PreparedStatement pst;
        Timestamp current_t = new Timestamp(System.currentTimeMillis());
        try{
            pst=conn.prepareStatement("INSERT INTO conversation_messages(message,created_at,escort_id,member_id,conversation_id) VALUES (?,?,?,?,?)");
            pst.setString(1 ,m);
            pst.setTimestamp(2,current_t);
            pst.setInt(3,c.getEscort().getId());
            pst.setInt(4,c.getMember().getId());
            pst.setInt(5,c.getId());
            pst.executeQuery();
        }catch (Exception e){

        }

    }
    public void updateM(int id,int updt, int value){
        PreparedStatement pst;
        if(updt ==0){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET read_by_sender=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }
        if(updt ==1){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET read_by_receiver=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }
        if(updt ==2){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET removed_by_sender=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }
        if(updt ==3){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET removed_by_receiver=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }
        if(updt ==4){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET deleted_by_sender=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }
        if(updt ==5){
            try{
                pst=conn.prepareStatement("UPDATE conversation_messages SET deleted_by_receiver=?");
                pst.setInt(1,value);
                pst.executeUpdate();

            }catch (Exception e){

            }
        }

    }
    public ArrayList<ConversationMessage> getByConv(Conversation c){
        ArrayList<ConversationMessage> list=new ArrayList<ConversationMessage>();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst=conn.prepareStatement("SELECT * FROM conversation_messages WHERE conversation_id=?  ORDER BY created_at ASC ");
            pst.setInt(1,c.getId());
            rs=pst.executeQuery();
            while(rs.next()){
                ConversationMessage cm=new ConversationMessage();
                cm.setId(rs.getInt("id"));
                cm.setMessage(rs.getString("message"));
                boolean reads=false;
                boolean readr=false;
                boolean rems=false;
                boolean remr=false;
                boolean dels=false;
                boolean delr=false;
                if(rs.getInt(3)>0){
                    reads=true;
                }
                if(rs.getInt(4)>0){
                    readr=true;
                }
                if(rs.getInt(5)>0){
                    rems=true;
                }
                if(rs.getInt(6)>0){
                    remr=true;
                }
                if(rs.getInt(7)>0){
                    dels=true;
                }
                if(rs.getInt(8)>0){
                    delr=true;
                }


                cm.setReadBySender(reads);
                cm.setReadByReceiver(readr);
                cm.setRemovedBySender(rems);
                cm.setRemovedByReceiver(remr);
                cm.setDeletedBySender(dels);
                cm.setDeletedByReceiver(delr);
                cm.setEscort(c.getEscort());
                cm.setMember(c.getMember());
                cm.setConversation(c);
                list.add(cm);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}
