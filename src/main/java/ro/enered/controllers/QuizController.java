package ro.enered.controllers;

import ro.enered.entities.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by dioni on 12/23/2016.
 */
public class QuizController extends AbstractController{
    public static Quiz getAll(){
        Quiz q=new Quiz();
        ArrayList<BlogQuiz> quizz=new ArrayList<BlogQuiz>();
         ArrayList<BlogQuizResult> quizresult=new ArrayList<BlogQuizResult>();
         ArrayList<BlogQuizAnswer> quizans=new ArrayList<BlogQuizAnswer>();
         ArrayList<BlogQuizQuestion> bqq=new ArrayList<BlogQuizQuestion>();
        ArrayList<BlogTest> tests= new ArrayList<BlogTest>();
        q.setBqq(BlogQuizQuestionController.getAll());
        q.setQuizans(BlogQuizAnswerController.getAll());
        q.setQuizresult(BlogQuizResultController.getAll());
        q.setQuizz(BlogQuizController.getAll());
        q.setTests(BlogTestController.getTests());
        return q;
    }
}
