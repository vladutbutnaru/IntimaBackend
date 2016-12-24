package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.*;
import ro.enered.entities.BlogArticle;
import ro.enered.entities.BlogQuiz;
import ro.enered.entities.BlogTest;
import ro.enered.entities.Quiz;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dioni on 12/23/2016.
 */
public class Admin extends HttpServlet {
    private static final String ARTICLES = "/admin/blog";

    private static final String ARTICLE_EDIT = "/admin/blog/article/edit";
    private static final String ARTICLE_DELETE = "/admin/blog/article/delete";
    private static final String QUIZ = "/admin/blog/quiz";
    private static final String QUIZ_EDIT = "/admin/blog/quiz/edit";
    private static final String QUIZ_ADD = "/admin/blog/quiz/new";
    private static final String QUIZ_DELETE = "/admin/blog/quiz/delete";
    private static final String QUIZALL = "/admin/blog/quiz/all";
    private static final String RESULT = "/admin/blog/result/new";
    private static final String ANSWER = "/admin/blog/answer/new";
    private static final String RESULTDEL = "/admin/blog/result/delete";
    private static final String ANSWERDEL = "/admin/blog/answer/delete";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if(path.equals(QUIZ_EDIT)){
            BlogQuizController bqc=new BlogQuizController();
            BlogTestController btc= new BlogTestController();
            if(request.getParameter("id")!=""){
                bqc.update(Integer.parseInt(request.getParameter("id")),request.getParameter("intrebari"),request.getParameter("rezultat"));
                btc.update(request.getParameter("title"),request.getParameter("continut"),request.getParameter("poza"),Integer.parseInt(request.getParameter("id")));

            }else{
                int id =bqc.addN(request.getParameter("intrebari"),request.getParameter("rezultat"));
                btc.update(request.getParameter("title"),request.getParameter("continut"),request.getParameter("poza"),id);

            }


        }
        if(path.equals(ANSWER)){
            BlogQuizAnswerController bqa=new BlogQuizAnswerController();
            if(request.getParameter("id")!="") {
                bqa.update(Integer.parseInt(request.getParameter("id")),request.getParameter("title"), Integer.parseInt(request.getParameter("answers")));
            }else{

                bqa.addN(request.getParameter("title"), Integer.parseInt(request.getParameter("answers")));
            }
            }
        if(path.equals(RESULT)){
            if(request.getParameter("id")!=""){
                BlogQuizResultController bqr=new BlogQuizResultController();
                bqr.Update(request.getParameter("title"),Integer.parseInt(request.getParameter("minim")),Integer.parseInt(request.getParameter("maxim")),request.getParameter("content"),Integer.parseInt(request.getParameter("id")));

            }else{
                 BlogQuizResultController bqr=new BlogQuizResultController();
                bqr.AddNew(request.getParameter("title"),Integer.parseInt(request.getParameter("minim")),Integer.parseInt(request.getParameter("maxim")),request.getParameter("content"));

            }
        }
        if(path.equals(QUIZ_ADD)){

            BlogQuizQuestionController bqq=new BlogQuizQuestionController();
            if(request.getParameter("id")!="") {
                bqq.update(Integer.parseInt(request.getParameter("id")),request.getParameter("title"), request.getParameter("answers"));

            }else {
                bqq.addNew(request.getParameter("title"), request.getParameter("answers"));
            }
            }

        if (path.equals(ARTICLES)) {
            ArrayList<BlogArticle> articles = new ArrayList<BlogArticle>();
            articles= BlogArticleController.getArticlesInCategory(0);
            System.out.println(articles.size());
            String json = new Gson().toJson(articles);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if(path.equals(ARTICLE_EDIT)){
            BlogArticleController bac=new BlogArticleController();
            if(request.getParameter("id")!=""){
                bac.updateArt(request.getParameter("title"),Integer.parseInt(request.getParameter("category")),request.getParameter("poza"),request.getParameter("continut"),Integer.parseInt(request.getParameter("id")));
            }else{
                bac.addNew(request.getParameter("title"),Integer.parseInt(request.getParameter("category")),request.getParameter("poza"),request.getParameter("continut"),1);
            }


        }
        if(path.equals(ARTICLE_DELETE)){
            BlogArticleController bac=new BlogArticleController();
            bac.deleteArt(Integer.parseInt(request.getParameter("id")));
        }
        if(path.equals(QUIZ)){

            BlogTestController btc =new BlogTestController();
            ArrayList<BlogTest> list=btc.getTests();
            System.out.println(list.size());
            String json = new Gson().toJson(list);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if(path.equals(QUIZALL)){

            QuizController qc =new QuizController();
            Quiz list=qc.getAll();

            String json = new Gson().toJson(list);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }


    }
}
