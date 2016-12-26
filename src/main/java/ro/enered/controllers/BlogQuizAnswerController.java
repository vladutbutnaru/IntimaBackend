package ro.enered.controllers;

import ro.enered.entities.BlogQuizAnswer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizAnswerController extends AbstractController {
    public static ArrayList<BlogQuizAnswer> getAnswersForQuestion(String ids) {
        ArrayList<BlogQuizAnswer> answers = new ArrayList<BlogQuizAnswer>();
        for (String id : ids.split(",")) {

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
                    answer.setTitle_eng(rs.getString(5));
                    answer.setTitle_de(rs.getString(6));
                    answer.setTitle_fr(rs.getString(7));
                    answer.setTitle_it(rs.getString(8));
                    answer.setTitle_ru(rs.getString(9));
                    answer.setTitle_es(rs.getString(10));
                    answer.setTitle_pr(rs.getString(11));
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

    public static ArrayList<BlogQuizAnswer> getAll() {
        ArrayList<BlogQuizAnswer> answers = new ArrayList<BlogQuizAnswer>();


        PreparedStatement stmt;

        ResultSet rs;

        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_quiz_answers");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BlogQuizAnswer answer = new BlogQuizAnswer();
                answer.setId(rs.getInt(1));
                answer.setTitle(rs.getString(2));
                answer.setScore(rs.getInt(3));
                answer.setTitle_eng(rs.getString(5));
                answer.setTitle_de(rs.getString(6));
                answer.setTitle_fr(rs.getString(7));
                answer.setTitle_it(rs.getString(8));
                answer.setTitle_ru(rs.getString(9));
                answer.setTitle_es(rs.getString(10));
                answer.setTitle_pr(rs.getString(11));
                answers.add(answer);

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }
        return answers;
    }

    public static void addN(String title, int score) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("INSERT INTO blog_quiz_answers(title,score) VALUES (?,?)");
            pst.setString(1, title);
            pst.setInt(2, score);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(int id, String title, int score , int lang) {
        PreparedStatement pst;
        if(lang==1) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==2) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_en=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==3) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_de=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==4) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_fr=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==5) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_it=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==6) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_ru=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==7) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_es=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==8) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_answers set title_pr=?,score=? where id=?");
                pst.setString(1, title);
                pst.setInt(2, score);
                pst.setInt(3, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
