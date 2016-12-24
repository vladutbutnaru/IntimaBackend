package ro.enered.controllers;

import ro.enered.entities.BlogQuiz;
import ro.enered.entities.BlogTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    public static ArrayList<BlogQuiz> getAll(){
        ArrayList<BlogQuiz> bq = new ArrayList<BlogQuiz>();
        PreparedStatement stmt;

        ResultSet rs;

        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_quiz ");

            rs = stmt.executeQuery();

            if (rs.next()) {
                BlogQuiz b=new BlogQuiz();
                b.setId(rs.getInt(1));
                b.setQuestions(BlogQuizQuestionController.getQuestionsForQuiz(rs.getString(2)));
                b.setResults(BlogQuizResultController.getResultsForQuiz(rs.getString(3)));
                bq.add(b);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }



        return bq;


    }
    public static int addN(String questions,String results){
        PreparedStatement pst;
        ResultSet rs;
        int id=0;
        try {
            pst=conn.prepareStatement("insert into blog_quiz(questions,results) VALUES (?,?)");
            pst.setString(1,questions);
            pst.setString(2,results);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            pst=conn.prepareStatement("select id from blog_quiz where questions=? AND results=?");
            pst.setString(1,questions);
            pst.setString(2,results);
            rs=pst.executeQuery();
            while(rs.next()){
                id=rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    public static void update(int id,String quest,String res){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("UPDATE blog_quiz set questions=?,results=? where id=?");
            pst.setInt(1,id);
            pst.setString(2,quest);
            pst.setString(3,res);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
