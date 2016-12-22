package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogArticle {
    private int id;
    private BlogArticleCategory category;
    private String title;
    private Administrator publisher;
    private Timestamp publishedDate;
    private String featuredImage;
    private String content;
    private String images;
    private int votes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BlogArticleCategory getCategory() {
        return category;
    }

    public void setCategory(BlogArticleCategory category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Administrator getPublisher() {
        return publisher;
    }

    public void setPublisher(Administrator publisher) {
        this.publisher = publisher;
    }

    public Timestamp getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Timestamp publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}
