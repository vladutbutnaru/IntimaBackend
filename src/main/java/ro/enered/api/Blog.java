package ro.enered.api;

import com.google.gson.Gson;

import ro.enered.controllers.BlogArticleController;
import ro.enered.controllers.BlogTestController;
import ro.enered.entities.Article;
import ro.enered.entities.BlogArticle;
import ro.enered.entities.BlogTest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by macbook on 21/12/2016.
 */
public class Blog extends HttpServlet {
    private static final String ARTICLES = "/blog/articles";
    private static final String ARTICLE = "/blog/article";
    private static final String JOKES = "/blog/jokes";
    private static final String TESTS = "/blog/tests";
    private static final String TEST = "/blog/test";

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
         if(request.getParameter("category").equals("")){

             articles= BlogArticleController.getArticlesInCategory(0);

         }
         else{

             articles= BlogArticleController.getArticlesInCategory(Integer.parseInt(request.getParameter("category")));
         }


            String json = new Gson().toJson(articles);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(ARTICLE)) {
            int articleID = Integer.parseInt(request.getParameter("id"));
            BlogArticle article = BlogArticleController.getById(articleID);
            String json = new Gson().toJson(article);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(TESTS)) {
           ArrayList<BlogTest> tests = new ArrayList<BlogTest>();

           tests =  BlogTestController.getTests();
            String json = new Gson().toJson(tests);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(TEST)) {
           BlogTest test = new BlogTest();

            test =  BlogTestController.getById(Integer.parseInt(request.getParameter("id")));
            String json = new Gson().toJson(test);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
    }
}
