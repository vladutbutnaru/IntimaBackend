package ro.enered.controllers;

import ro.enered.entities.BlogContact;
import ro.enered.entities.BlogNewsletter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 29/12/2016.
 */
public class BlogNewsletterController extends AbstractController {

    public static ArrayList<BlogNewsletter> getAll() {
        ArrayList<BlogNewsletter> list = new ArrayList<BlogNewsletter>();
        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement("select * from blog_newsletter");
            rs = pst.executeQuery();
            while (rs.next()) {
                BlogNewsletter x = new BlogNewsletter();
                x.setId(rs.getInt(1));
                x.setEmail(rs.getString(2));
                list.add(x);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void insertNewsletter(String email){

        PreparedStatement pst;
        ResultSet rs;
        try {
            pst = conn.prepareStatement("INSERT INTO blog_newsletter (email) VALUES (?)");
            pst.setString(1,email);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
