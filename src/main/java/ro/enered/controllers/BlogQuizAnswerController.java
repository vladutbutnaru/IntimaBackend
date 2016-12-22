package ro.enered.controllers;

import ro.enered.entities.BlogQuizAnswer;
import ro.enered.entities.BlogQuizQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizAnswerController extends AbstractController {
    public static ArrayList<BlogQuizAnswer> getAnswersForQuestion(String ids){
        ArrayList<BlogQuizAnswer> answers = new ArrayList<BlogQuizAnswer>();
        for(String id : ids.split(",")){

            PreparedStatement stmt;

            ResultSet rs;

            try {
                //get all tests
                stmt = conn.prepareStatement("SELECT * FROM blog_quiz_answers WHERE id = ? ");
                stmt.setInt(1, Integer.parseInt(id));
                rs = stmt.executeQuery();

                while (rs.next()) {
                   BlogQuizAnswer answer = new BlogQuizAnswer();
                    answer.setId(rs.getInt(1));
                    answer.setTitle(rs.getString(2));
                    answer.setScore(rs.getInt(3));
                    answers.add(answer);

                }

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                logger.error(ex.getMessage());

            }






        }





        return answers;




    }
}
