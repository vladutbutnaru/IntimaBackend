package ro.enered.controllers;

import ro.enered.entities.BlogQuiz;
import ro.enered.entities.BlogTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizController  extends AbstractController{

    public static BlogQuiz getById(int id){
        BlogQuiz b = new BlogQuiz();
        PreparedStatement stmt;

        ResultSet rs;

        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_quiz WHERE id = ?");
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                b.setId(rs.getInt(1));
                b.setQuestions(BlogQuizQuestionController.getQuestionsForQuiz(rs.getString(2)));
                b.setResults(BlogQuizResultController.getResultsForQuiz(rs.getString(3)));

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }



        return b;


    }
}
