package ro.enered.controllers;

import ro.enered.entities.BlogArticle;
import ro.enered.entities.BlogTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogTestController extends AbstractController{

    public static ArrayList<BlogTest> getTests(){
    ArrayList<BlogTest> tests = new ArrayList<BlogTest>();
        PreparedStatement stmt;

        ResultSet rs;

        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_tests ORDER BY published_at DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BlogTest test = new BlogTest();
                test.setId(rs.getInt(1));
                test.setTitle(rs.getString(2));
                test.setContent(rs.getString(3));
                test.setPublishedAt(rs.getTimestamp(4));
                test.setPublisher(AdminController.getById(rs.getInt(5)));
                test.setImage(rs.getString(6));
                test.setQuiz(BlogQuizController.getById(rs.getInt(7)));
                tests.add(test);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }



        return tests;


    }
    public static BlogTest getById(int id){
        BlogTest test = new BlogTest();
        PreparedStatement stmt;

        ResultSet rs;
        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_tests WHERE id = ?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                test.setId(rs.getInt(1));
                test.setTitle(rs.getString(2));
                test.setContent(rs.getString(3));
                test.setPublishedAt(rs.getTimestamp(4));
                test.setPublisher(AdminController.getById(rs.getInt(5)));
                test.setImage(rs.getString(6));
                test.setQuiz(BlogQuizController.getById(rs.getInt(7)));

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


        return test;


    }


}
