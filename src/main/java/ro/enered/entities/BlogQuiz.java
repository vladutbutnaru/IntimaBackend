package ro.enered.entities;

import java.util.ArrayList;

/**
 * Created by macbook on 22/12/2016.
 */
public class BlogQuiz {
    private int id;
    private ArrayList<BlogQuizQuestion> questions;
    private ArrayList<BlogQuizResult> results;

    public ArrayList<BlogQuizResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<BlogQuizResult> results) {
        this.results = results;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<BlogQuizQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<BlogQuizQuestion> questions) {
        this.questions = questions;
    }
}
