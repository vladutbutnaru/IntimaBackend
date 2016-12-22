package ro.enered.entities;

import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuizQuestion {
    private int id;
    private String title;
    private ArrayList<BlogQuizAnswer> answers;

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

    public ArrayList<BlogQuizAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<BlogQuizAnswer> answers) {
        this.answers = answers;
    }
}
