package ro.enered.entities;

import java.util.ArrayList;

/**
 * Created by dioni on 12/23/2016.
 */
public class Quiz {
    private ArrayList<BlogQuiz> quizz;
    private ArrayList<BlogQuizResult> quizresult;
    private ArrayList<BlogQuizAnswer> quizans;
    private ArrayList<BlogQuizQuestion> bqq;

    public ArrayList<BlogQuiz> getQuizz() {
        return quizz;
    }

    public void setQuizz(ArrayList<BlogQuiz> quizz) {
        this.quizz = quizz;
    }

    public ArrayList<BlogQuizResult> getQuizresult() {
        return quizresult;
    }

    public void setQuizresult(ArrayList<BlogQuizResult> quizresult) {
        this.quizresult = quizresult;
    }

    public ArrayList<BlogQuizAnswer> getQuizans() {
        return quizans;
    }

    public void setQuizans(ArrayList<BlogQuizAnswer> quizans) {
        this.quizans = quizans;
    }

    public ArrayList<BlogQuizQuestion> getBqq() {
        return bqq;
    }

    public void setBqq(ArrayList<BlogQuizQuestion> bqq) {
        this.bqq = bqq;
    }
}
