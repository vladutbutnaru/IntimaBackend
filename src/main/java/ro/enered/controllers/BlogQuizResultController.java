package ro.enered.controllers;

import ro.enered.entities.BlogQuizResult;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizResultController extends AbstractController {

    public static ArrayList<BlogQuizResult> getResultsForQuiz(String ids) {

        ArrayList<BlogQuizResult> results = new ArrayList<BlogQuizResult>();

        for (String id : ids.split(",")) {

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
                    result.setContent(rs.getString(5));
                    result.setTitle_eng(rs.getString(7));
                    result.setTitle_de(rs.getString(8));
                    result.setTitle_fr(rs.getString(9));
                    result.setTitle_it(rs.getString(10));
                    result.setTitle_ru(rs.getString(11));
                    result.setTitle_es(rs.getString(12));
                    result.setTitle_pr(rs.getString(13));
                    result.setContent_eng(rs.getString(14));
                    result.setContent_de(rs.getString(15));
                    result.setContent_fr(rs.getString(16));
                    result.setContent_it(rs.getString(17));
                    result.setContent_ru(rs.getString(18));
                    result.setContent_es(rs.getString(19));
                    result.setContent_pr(rs.getString(20));
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

    public static ArrayList<BlogQuizResult> getAll() {

        ArrayList<BlogQuizResult> results = new ArrayList<BlogQuizResult>();


        PreparedStatement stmt;

        ResultSet rs;

        try {
            //get all tests
            stmt = conn.prepareStatement("SELECT * FROM blog_quiz_results");

            rs = stmt.executeQuery();

            while (rs.next()) {
                BlogQuizResult result = new BlogQuizResult();
                result.setId(rs.getInt(1));
                result.setTitle(rs.getString(2));
                result.setMin(rs.getInt(3));
                result.setMax(rs.getInt(4));
                result.setContent(rs.getString(5));
                result.setTitle_eng(rs.getString(7));
                result.setTitle_de(rs.getString(8));
                result.setTitle_fr(rs.getString(9));
                result.setTitle_it(rs.getString(10));
                result.setTitle_ru(rs.getString(11));
                result.setTitle_es(rs.getString(12));
                result.setTitle_pr(rs.getString(13));
                result.setContent_eng(rs.getString(14));
                result.setContent_de(rs.getString(15));
                result.setContent_fr(rs.getString(16));
                result.setContent_it(rs.getString(17));
                result.setContent_ru(rs.getString(18));
                result.setContent_es(rs.getString(19));
                result.setContent_pr(rs.getString(20));

                results.add(result);

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


        return results;

    }

    public static void AddNew(String t, int mi, int ma, String content) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("INSERT INTO blog_quiz_results(`title`,`min`,`max`,`content`)  VALUES (?,?,?,?)");
            pst.setString(1, t);
            pst.setInt(2, mi);
            pst.setInt(3, ma);
            pst.setString(4, content);
            pst.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void Update(String t, int mi, int ma, String content, int id,int lang) {
        PreparedStatement pst;
        if (lang == 1) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title`=?,`min`=?,`max`=?,`content`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 2) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_en`=?,`min`=?,`max`=?,`content_en`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 3) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_de`=?,`min`=?,`max`=?,`content_de`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 4) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_fr`=?,`min`=?,`max`=?,`content_fr`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 5) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_it`=?,`min`=?,`max`=?,`content_it`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 6) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_ru`=?,`min`=?,`max`=?,`content_rus`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 7) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_es`=?,`min`=?,`max`=?,`content_es`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (lang == 8) {
            try {
                pst = conn.prepareStatement("UPDATE blog_quiz_results SET `title_pr`=?,`min`=?,`max`=?,`content_pr`=? where `id`=?");
                pst.setString(1, t);
                pst.setInt(2, mi);
                pst.setInt(3, ma);
                pst.setString(4, content);
                pst.setInt(5, id);
                pst.executeUpdate();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
