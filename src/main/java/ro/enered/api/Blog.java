package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.*;
import ro.enered.entities.BlogArticle;
import ro.enered.entities.BlogQuizResult;
import ro.enered.entities.BlogTest;
import ro.enered.entities.FileMeta;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by macbook on 21/12/2016.
 */
@MultipartConfig
public class Blog extends HttpServlet {
    private static final String ARTICLES = "/blog/articles";
    private static final String ARTICLE = "/blog/article";
    private static final String JOKES = "/blog/jokes";
    private static final String TESTS = "/blog/tests";
    private static final String TEST = "/blog/test";
    private static final String VOTE = "/blog/article/vote";
    private static final String FINISHED = "/blog/test/finished";
    private static final String UPLOADFILE = "/blog/upload";
    private static final String NEWSLETTER = "/blog/newsletter";
    private static final String CONTACT = "/blog/contact";

    // this will store uploaded files
    private static List<FileMeta> files = new LinkedList<FileMeta>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(FINISHED)) {
            int score = Integer.parseInt(request.getParameter("score"));
            int id = Integer.parseInt(request.getParameter("quiz_id"));
            ArrayList<BlogQuizResult> res = BlogTestController.getById(id).getQuiz().getResults();
            int poz = 0;
            for (BlogQuizResult x : res) {
                System.out.println(x.getMin() + "-" + x.getMax() + "-" + score);
                if (x.getMin() < score && x.getMax() > score) {
                    response.getWriter().write(poz + "");
                    break;
                }
                poz++;

            }


        }
        if (path.equals(ARTICLES)) {
            ArrayList<BlogArticle> articles = new ArrayList<BlogArticle>();
            if (request.getParameter("category").equals("")) {

                articles = BlogArticleController.getArticlesInCategory(0);

            } else {

                articles = BlogArticleController.getArticlesInCategory(Integer.parseInt(request.getParameter("category")));
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

            tests = BlogTestController.getTests();
            String json = new Gson().toJson(tests);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(TEST)) {
            BlogTest test = new BlogTest();

            test = BlogTestController.getById(Integer.parseInt(request.getParameter("id")));
            String json = new Gson().toJson(test);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(VOTE)) {
            String ip = request.getParameter("ip");
            int articleId = Integer.parseInt(request.getParameter("article"));
            BlogVoteController.vote(ip, articleId);


        }
        if(path.equals(NEWSLETTER)){
            BlogNewsletterController.insertNewsletter(request.getParameter("email"));


        }
        if(path.equals(CONTACT)){
            BlogContactController.insertContact(request.getParameter("email"),request.getParameter("title"),request.getParameter("content"));


        }

    }
}
