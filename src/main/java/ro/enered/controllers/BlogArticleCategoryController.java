package ro.enered.controllers;

import ro.enered.entities.BlogArticleCategory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogArticleCategoryController extends AbstractController{

    public static BlogArticleCategory getById(int id){
    BlogArticleCategory category =new BlogArticleCategory();
        PreparedStatement stmt;

        ResultSet rs;
        try {

            stmt = conn.prepareStatement("SELECT * FROM blog_article_categories WHERE id = ?");
           stmt.setInt(1,id);

            rs = stmt.executeQuery();

            if (rs.next()) {

                category.setId(rs.getInt(1));
                category.setCode(rs.getString(2));

            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

    return category;

    }
}
