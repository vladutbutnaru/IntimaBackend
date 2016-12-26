package ro.enered.controllers;

import ro.enered.entities.BlogTest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogTestController extends AbstractController {

    public static ArrayList<BlogTest> getTests() {
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
                test.setTitle_eng(rs.getString(7));
                test.setTitle_de(rs.getString(8));
                test.setTitle_fr(rs.getString(9));
                test.setTitle_it(rs.getString(10));
                test.setTitle_ru(rs.getString(11));
                test.setTitle_es(rs.getString(12));
                test.setTitle_pr(rs.getString(13));
                test.setContent_eng(rs.getString(14));
                test.setContent_de(rs.getString(15));
                test.setContent_fr(rs.getString(16));
                test.setContent_it(rs.getString(17));
                test.setContent_ru(rs.getString(18));
                test.setContent_es(rs.getString(19));
                test.setContent_pr(rs.getString(20));
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

    public static BlogTest getById(int id) {
        BlogTest test = new BlogTest();
        PreparedStatement stmt;

        ResultSet rs;
        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_tests WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {

                test.setId(rs.getInt(1));
                test.setTitle(rs.getString(2));
                test.setContent(rs.getString(3));
                test.setPublishedAt(rs.getTimestamp(4));
                test.setPublisher(AdminController.getById(rs.getInt(5)));
                test.setImage(rs.getString(6));
                test.setQuiz(BlogQuizController.getById(rs.getInt(7)));
                test.setTitle_eng(rs.getString(7));
                test.setTitle_de(rs.getString(8));
                test.setTitle_fr(rs.getString(9));
                test.setTitle_it(rs.getString(10));
                test.setTitle_ru(rs.getString(11));
                test.setTitle_es(rs.getString(12));
                test.setTitle_pr(rs.getString(13));
                test.setContent_eng(rs.getString(14));
                test.setContent_de(rs.getString(15));
                test.setContent_fr(rs.getString(16));
                test.setContent_it(rs.getString(17));
                test.setContent_ru(rs.getString(18));
                test.setContent_es(rs.getString(19));
                test.setContent_pr(rs.getString(20));

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

    public static void addN(String title, String content, String image, int id) {
        PreparedStatement pst;
        Date date = new Date();
        try {
            pst = conn.prepareStatement("insert into blog_tests(title,content,published_at,publisher_id,image,quiz_id) values(?,?,?,?,?,?)");
            pst.setString(1, title);
            pst.setString(2, content);
            pst.setTimestamp(3, new Timestamp(date.getTime()));
            pst.setInt(4, 1);
            pst.setString(5, image);
            pst.setInt(6, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void update(String title, String content, String image, int id,int lang) {
        PreparedStatement pst;
        if(lang==1) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title=?,content=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==2) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_en=?,content_en=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==3) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_de=?,content_de=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==4) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_fr=?,content_fr=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==5) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_it=?,content_it=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==6) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_ru=?,content_rus=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==7) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_es=?,content_es=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==8) {
            try {
                pst = conn.prepareStatement("update blog_tests SET title_pr=?,content_pr=?,image=? where id=?");
                pst.setString(1, title);
                pst.setString(2, content);
                pst.setString(3, image);
                pst.setInt(4, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
