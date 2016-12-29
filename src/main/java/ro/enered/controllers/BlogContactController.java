package ro.enered.controllers;

import ro.enered.entities.BlogArticleCategory;
import ro.enered.entities.BlogContact;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 29/12/2016.
 */
public class BlogContactController extends AbstractController{
    public static ArrayList<BlogContact> getAll() {
        ArrayList<BlogContact> list = new ArrayList<BlogContact>();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement("select * from blog_contact");
            rs = pst.executeQuery();
            while (rs.next()) {
                BlogContact x = new BlogContact();
                x.setId(rs.getInt(1));
                x.setTitle(rs.getString(4));
                x.setContent(rs.getString(2));
                x.setEmail(rs.getString(3));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
public static void insertContact(String email, String title, String content){

    PreparedStatement pst;
    ResultSet rs;
    try {
        pst = conn.prepareStatement("INSERT INTO blog_contact(message,email,title) VALUES (?,?,?)");
        pst.setString(1,content);
        pst.setString(2,email);
        pst.setString(3,title);
        pst.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }


}


}
