package ro.enered.controllers;

import ro.enered.entities.BlogVote;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by macbook on 25/12/2016.
 */
public class BlogVoteController extends AbstractController {

    public static ArrayList<BlogVote> getVotesForArticle(int articleId) {
        ArrayList<BlogVote> votes = new ArrayList<BlogVote>();
        PreparedStatement stmt;

        ResultSet rs;
        try {

            stmt = conn.prepareStatement("SELECT * FROM blog_votes WHERE vote_article = ? ");
            stmt.setInt(1, articleId);

            rs = stmt.executeQuery();

            while (rs.next()) {
                BlogVote vote = new BlogVote();
                vote.setId(rs.getInt(1));
                //vote.setArticle(BlogArticleController.getById(rs.getInt(3)));
                vote.setIp(rs.getString(2));
                votes.add(vote);


            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }

        return votes;

    }

    public static void vote(String ip, int articleId) {
        PreparedStatement stmt;

        ResultSet rs;
        try {

            stmt = conn.prepareStatement("INSERT INTO blog_votes(vote_ip,vote_article) VALUES(?,?)");
            stmt.setString(1, ip);
            stmt.setInt(2, articleId);
            stmt.executeUpdate();
            BlogArticleController.voteArticle(articleId);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            logger.error(ex.getMessage());

        }


    }
}
