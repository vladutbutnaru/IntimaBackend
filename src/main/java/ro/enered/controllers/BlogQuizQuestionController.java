package ro.enered.controllers;

import ro.enered.entities.BlogQuizQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizQuestionController extends AbstractController {

    public static ArrayList<BlogQuizQuestion> getQuestionsForQuiz(String questionIDs) {
        ArrayList<BlogQuizQuestion> questions = new ArrayList<BlogQuizQuestion>();
        for (String id : questionIDs.split(",")) {

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
                    question.setTitle_eng(rs.getString(5));
                    question.setTitle_de(rs.getString(6));
                    question.setTitle_fr(rs.getString(7));
                    question.setTitle_it(rs.getString(8));
                    question.setTitle_ru(rs.getString(9));
                    question.setTitle_es(rs.getString(10));
                    question.setTitle_pr(rs.getString(11));

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

    public static ArrayList<BlogQuizQuestion> getAll() {
        ArrayList<BlogQuizQuestion> questions = new ArrayList<BlogQuizQuestion>();
        PreparedStatement stmt;
        ResultSet rs;
        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_quiz_question");
            rs = stmt.executeQuery();

            while (rs.next()) {
                BlogQuizQuestion question = new BlogQuizQuestion();
                question.setId(rs.getInt(1));
                question.setTitle(rs.getString(2));
                question.setAnswers(BlogQuizAnswerController.getAnswersForQuestion(rs.getString(3)));
                question.setTitle_eng(rs.getString(5));
                question.setTitle_de(rs.getString(6));
                question.setTitle_fr(rs.getString(7));
                question.setTitle_it(rs.getString(8));
                question.setTitle_ru(rs.getString(9));
                question.setTitle_es(rs.getString(10));
                question.setTitle_pr(rs.getString(11));
                questions.add(question);

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return questions;

    }

    public static void addNew(String t, String a) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("INSERT  INTO blog_quiz_question(title,answers) VALUES (?,?)");
            pst.setString(1, t);
            pst.setString(2, a);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void update(int id, String t, String cont,int lang) {
        PreparedStatement pst;
        if(lang==1) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==2) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_en=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==3) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_de=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==4) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_fr=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==5) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_it=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==6) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_ru=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==7) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_es=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==8) {
            try {
                pst = conn.prepareStatement("update blog_quiz_question set title_pr=?,answers=? WHERE id=?");
                pst.setString(1, t);
                pst.setString(2, cont);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
