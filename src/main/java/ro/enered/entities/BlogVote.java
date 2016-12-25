package ro.enered.entities;

/**
 * Created by macbook on 25/12/2016.
 */
public class BlogVote {
    private int id;
    private BlogArticle article;
    private String ip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BlogArticle getArticle() {
        return article;
    }

    public void setArticle(BlogArticle article) {
        this.article = article;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
