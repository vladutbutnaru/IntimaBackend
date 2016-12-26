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
    private String title_eng;
    private String content_eng;
    private String title_de;
    private String content_de;
    private String title_it;
    private String content_it;
    private String title_es;
    private String content_es;
    private String title_pr;
    private String content_pr;
    private String title_ru;
    private String content_ru;
    private String title_fr;
    private String content_fr;

    public String getTitle_eng() {
        return title_eng;
    }

    public void setTitle_eng(String title_eng) {
        this.title_eng = title_eng;
    }

    public String getContent_eng() {
        return content_eng;
    }

    public void setContent_eng(String content_eng) {
        this.content_eng = content_eng;
    }

    public String getTitle_de() {
        return title_de;
    }

    public void setTitle_de(String title_de) {
        this.title_de = title_de;
    }

    public String getContent_de() {
        return content_de;
    }

    public void setContent_de(String content_de) {
        this.content_de = content_de;
    }

    public String getTitle_it() {
        return title_it;
    }

    public void setTitle_it(String title_it) {
        this.title_it = title_it;
    }

    public String getContent_it() {
        return content_it;
    }

    public void setContent_it(String content_it) {
        this.content_it = content_it;
    }

    public String getTitle_es() {
        return title_es;
    }

    public void setTitle_es(String title_es) {
        this.title_es = title_es;
    }

    public String getContent_es() {
        return content_es;
    }

    public void setContent_es(String content_es) {
        this.content_es = content_es;
    }

    public String getTitle_pr() {
        return title_pr;
    }

    public void setTitle_pr(String title_pr) {
        this.title_pr = title_pr;
    }

    public String getContent_pr() {
        return content_pr;
    }

    public void setContent_pr(String content_pr) {
        this.content_pr = content_pr;
    }

    public String getTitle_ru() {
        return title_ru;
    }

    public void setTitle_ru(String title_ru) {
        this.title_ru = title_ru;
    }

    public String getContent_ru() {
        return content_ru;
    }

    public void setContent_ru(String content_ru) {
        this.content_ru = content_ru;
    }

    public String getTitle_fr() {
        return title_fr;
    }

    public void setTitle_fr(String title_fr) {
        this.title_fr = title_fr;
    }

    public String getContent_fr() {
        return content_fr;
    }

    public void setContent_fr(String content_fr) {
        this.content_fr = content_fr;
    }

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
