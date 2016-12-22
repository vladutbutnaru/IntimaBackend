package ro.enered.controllers;

import ro.enered.entities.BlogQuizQuestion;
import ro.enered.entities.BlogTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizQuestionController extends AbstractController{

    public static ArrayList<BlogQuizQuestion> getQuestionsForQuiz(String questionIDs){
        ArrayList<BlogQuizQuestion> questions = new ArrayList<BlogQuizQuestion>();
        for(String id : questionIDs.split(",")){

            PreparedStatement stmt;

            ResultSet rs;

            try {
                //get all tests
                stmt = conn.prepareStatement("SELECT * FROM blog_quiz_question WHERE id = ? ");
                stmt.setInt(1, Integer.parseInt(id));
                rs = stmt.executeQuery();

                while (rs.next()) {
                   BlogQuizQuestion question = new BlogQuizQuestion();
                    question.setId(rs.getInt(1));
                    question.setTitle(rs.getString(2));
                    question.setAnswers(BlogQuizAnswerController.getAnswersForQuestion(rs.getString(3)));

                    questions.add(question);

                }

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                logger.error(ex.getMessage());

            }






        }



        return questions;

    }
}
