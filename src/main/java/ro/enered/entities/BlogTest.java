package ro.enered.entities;

import java.sql.Timestamp;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogTest {
    private int id;
    private String title;
    private String image;
    private String content;
    private Timestamp publishedAt;
    private Administrator publisher;
    private BlogQuiz quiz;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(Timestamp publishedAt) {
        this.publishedAt = publishedAt;
    }

    public Administrator getPublisher() {
        return publisher;
    }

    public void setPublisher(Administrator publisher) {
        this.publisher = publisher;
    }

    public BlogQuiz getQuiz() {
        return quiz;
    }

    public void setQuiz(BlogQuiz quiz) {
        this.quiz = quiz;
    }
}
