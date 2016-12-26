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

    public static ArrayList<BlogArticle> getArticlesInCategory(int categoryId) {

        ArrayList<BlogArticle> articles = new ArrayList<BlogArticle>();

        PreparedStatement stmt;

        ResultSet rs;

        try {
            if (categoryId > 0) {
                stmt = conn.prepareStatement("SELECT * FROM blog_articles WHERE category = ? ORDER BY published_date DESC");
                stmt.setInt(1, categoryId);
            } else {
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
                a.setBlogVotes(BlogVoteController.getVotesForArticle(a.getId()));
                a.setTitle_de(rs.getString(11));
                a.setTitle_eng(rs.getString(10));
                a.setTitle_fr(rs.getString(12));
                a.setTitle_it(rs.getString(13));
                a.setTitle_ru(rs.getString(14));
                a.setTitle_es(rs.getString(15));
                a.setTitle_pr(rs.getString(16));
                a.setContent_de(rs.getString(18));
                a.setContent_eng(rs.getString(17));
                a.setContent_fr(rs.getString(19));
                a.setContent_it(rs.getString(20));
                a.setContent_ru(rs.getString(21));
                a.setContent_es(rs.getString(22));
                a.setContent_pr(rs.getString(23));

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

    public static BlogArticle getById(int articleID) {
        BlogArticle a = new BlogArticle();

        PreparedStatement stmt;

        ResultSet rs;

        try {


            stmt = conn.prepareStatement("SELECT * FROM blog_articles WHERE id = ?");
            stmt.setInt(1, articleID);

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
                a.setBlogVotes(BlogVoteController.getVotesForArticle(a.getId()));
                a.setTitle_de(rs.getString(11));
                a.setTitle_eng(rs.getString(10));
                a.setTitle_fr(rs.getString(12));
                a.setTitle_it(rs.getString(13));
                a.setTitle_ru(rs.getString(14));
                a.setTitle_es(rs.getString(15));
                a.setTitle_pr(rs.getString(16));
                a.setContent_de(rs.getString(18));
                a.setContent_eng(rs.getString(17));
                a.setContent_fr(rs.getString(19));
                a.setContent_it(rs.getString(20));
                a.setContent_ru(rs.getString(21));
                a.setContent_es(rs.getString(22));
                a.setContent_pr(rs.getString(23));

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

    public static void addNew(String title, int categ, String poza, String continut, int id_u) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("INSERT into blog_articles(category,title,publisher_id,featured_image,published_date,content,images,votes,title_en, title_de, title_fr, title_it, title_rus, title_es, title_pr, content_en, content_de, content_fr, content_it, content_rus, content_es, content_pr) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setInt(1, categ);
            pst.setString(2, title);
            pst.setInt(3, id_u);
            pst.setString(4, poza);
            Date date = new Date();
            pst.setTimestamp(5, new Timestamp(date.getTime()));
            pst.setString(6, continut);
            pst.setString(7, "");
            pst.setInt(8, 0);
            pst.setString(9," ");
            pst.setString(10," ");
            pst.setString(11," ");
            pst.setString(12," ");
            pst.setString(13," ");
            pst.setString(14," ");
            pst.setString(15," ");
            pst.setString(16," ");
            pst.setString(17," ");
            pst.setString(18," ");
            pst.setString(19," ");
            pst.setString(20," ");
            pst.setString(21," ");
            pst.setString(22," ");

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateArt(String title, int categ, String poza, String continut, int id,int lang) {
        PreparedStatement pst;
        if(lang==1) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title=?,featured_image=?,content=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==2) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title_en=?,featured_image=?,content_en=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==3) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title_de=?,featured_image=?,content_de=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==4) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title_fr=?,featured_image=?,content_fr=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==5) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title_it=?,featured_image=?,content_it=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==6) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category_rus=?,title=?,featured_image=?,content_rus=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==7) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category=?,title_es=?,featured_image=?,content_es=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(lang==8) {
            try {
                pst = conn.prepareStatement("UPDATE blog_articles SET category_pr=?,title=?,featured_image=?,content_pr=? where id=?");
                pst.setInt(1, categ);
                pst.setString(2, title);
                pst.setString(3, poza);
                pst.setString(4, continut);
                pst.setInt(5, id);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void deleteArt(int id) {
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("DELETE FROM blog_articles where id=?");
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void voteArticle(int id){
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement("UPDATE blog_articles SET votes = votes+1 where id=?");
            pst.setInt(1, id);

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
