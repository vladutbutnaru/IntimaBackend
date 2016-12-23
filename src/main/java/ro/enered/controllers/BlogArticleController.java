package ro.enered.controllers;

import ro.enered.entities.BlogArticle;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogArticleController extends AbstractController {

    public static ArrayList<BlogArticle> getArticlesInCategory(int categoryId){

        ArrayList<BlogArticle> articles =new ArrayList<BlogArticle>();

        PreparedStatement stmt;

        ResultSet rs;

            try {
                if(categoryId>0) {
                    stmt = conn.prepareStatement("SELECT * FROM blog_articles WHERE category = ? ORDER BY published_date DESC");
                    stmt.setInt(1, categoryId);
                }
                else{
                    stmt = conn.prepareStatement("SELECT * FROM blog_articles ORDER BY published_date DESC");

                }
                rs = stmt.executeQuery();

                while (rs.next()) {
                    BlogArticle a = new BlogArticle();
                    a.setId(rs.getInt(1));
                    a.setCategory(BlogArticleCategoryController.getById(rs.getInt(2)));
                    a.setTitle(rs.getString(3));
                    a.setPublisher(AdminController.getById(rs.getInt(4)));
                    a.setPublishedDate(rs.getTimestamp(5));
                    a.setFeaturedImage(rs.getString(6));
                    a.setContent(rs.getString(7));
                    a.setVotes(rs.getInt(9));
                    articles.add(a);

                }

            } catch (SQLException ex) {
                // handle any errors
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                logger.error(ex.getMessage());

            }


        return articles;

    }

    public static BlogArticle getById(int articleID){
BlogArticle a = new BlogArticle();

        PreparedStatement stmt;

        ResultSet rs;

        try {


                stmt = conn.prepareStatement("SELECT * FROM blog_articles WHERE id = ?");
                stmt.setInt(1,articleID);

            rs = stmt.executeQuery();

            if (rs.next()) {

                a.setId(rs.getInt(1));
                a.setCategory(BlogArticleCategoryController.getById(rs.getInt(2)));
                a.setTitle(rs.getString(3));
                a.setPublisher(AdminController.getById(rs.getInt(4)));
                a.setPublishedDate(rs.getTimestamp(5));
                a.setFeaturedImage(rs.getString(6));
                a.setContent(rs.getString(7));
                a.setImages(rs.getString(8));
                a.setVotes(rs.getInt(9));


            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


        return a;

    }
    public static void addNew(String title,int categ,String poza,String continut,int id_u){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("INSERT into blog_articles(category,title,publisher_id,featured_image,published_date,content,images,votes) values(?,?,?,?,?,?,?,?)");
            pst.setInt(1,categ);
            pst.setString(2,title);
            pst.setInt(3,id_u);
            pst.setString(4,poza);
            Date date = new Date();
            pst.setTimestamp(5,new Timestamp(date.getTime()));
            pst.setString(6,continut);
            pst.setString(7,"");
            pst.setInt(8,0);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateArt(String title,int categ,String poza,String continut,int id){
        PreparedStatement pst;
        try {
            pst=conn.prepareStatement("UPDATE blog_articles SET category=?,title=?,featured_image=?,content=? where id=?");
            pst.setInt(1,categ);
            pst.setString(2,title);
            pst.setString(3,poza);
            pst.setString(4,continut);
            pst.setInt(5,id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteArt(int id){
        PreparedStatement pst;
        try {
        pst=conn.prepareStatement("DELETE FROM blog_articles where id=?");
        pst.setInt(1,id);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
