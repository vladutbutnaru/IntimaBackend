package ro.enered.controllers;

import ro.enered.entities.BlogQuizQuestion;
import ro.enered.entities.BlogQuizResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizResultController extends AbstractController{

    public static ArrayList<BlogQuizResult> getResultsForQuiz(String ids){

        ArrayList<BlogQuizResult> results = new ArrayList<BlogQuizResult>();

        for(String id : ids.split(",")){

            PreparedStatement stmt;

            ResultSet rs;

            try {
                //get all tests
                stmt = conn.prepareStatement("SELECT * FROM blog_quiz_results WHERE id = ? ");
                stmt.setInt(1, Integer.parseInt(id));
                rs = stmt.executeQuery();

                while (rs.next()) {
                    BlogQuizResult result = new BlogQuizResult();
                    result.setId(rs.getInt(1));
                    result.setTitle(rs.getString(2));
                    result.setMin(rs.getInt(3));
                    result.setMax(rs.getInt(4));
                    results.add(result);

                }

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                logger.error(ex.getMessage());

            }






        }



        return results;

    }
}
