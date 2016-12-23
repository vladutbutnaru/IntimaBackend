package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.BlogArticleController;
import ro.enered.controllers.BlogTestController;
import ro.enered.controllers.QuizController;
import ro.enered.entities.BlogArticle;
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
    private static final String ARTICLE_ADD = "/admin/blog/article/new";
    private static final String ARTICLE_EDIT = "/admin/blog/article/edit";
    private static final String ARTICLE_DELETE = "/admin/blog/article/delete";
    private static final String QUIZ = "/admin/blog/quiz";
    private static final String QUIZ_EDIT = "/admin/blog/quiz/edit";
    private static final String QUIZ_ADD = "/admin/blog/quiz/new";
    private static final String QUIZ_DELETE = "/admin/blog/quiz/delete";
    private static final String QUIZALL = "/admin/blog/quiz/all";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
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