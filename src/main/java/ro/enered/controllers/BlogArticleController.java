package ro.enered.controllers;

import ro.enered.entities.BlogArticle;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
}
