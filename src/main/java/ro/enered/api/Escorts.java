package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.EscortController;
import ro.enered.controllers.PersonPropertyController;
import ro.enered.entities.Escort;
import ro.enered.entities.EscortOfThe;
import ro.enered.entities.PersonProperty;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbook on 29/11/2016.
 */
public class Escorts extends javax.servlet.http.HttpServlet {
    private static final String NEW = "/escorts/new";
    private static final String ALL = "/escorts/all";
    private static final String RECOMMENDED = "/escorts/recommended";
    private static final String ENGLAND_TOUR = "/escorts/england";
    private static final String OTHER_COUNTRIES = "/escorts/other";
    private static final String OF_THE_MONTH = "/escorts/ofthemonth";
    private static final String INFO = "/escorts/info";
    private static final String FILTER = "/escorts/filter";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request,response);
        System.out.println(request.getServletPath());

    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException  {
        String path = request.getServletPath();
        System.out.println(path);
       if(path.equals(NEW)) {
           ArrayList<Escort> escorts = EscortController.getNewEscorts(4);


           String json = new Gson().toJson(escorts);
           response.setContentType("application/json");
           response.setCharacterEncoding("UTF-8");
           response.getWriter().write(json);
       }
       if(path.equals(ALL)) {
           ArrayList<Escort> escorts = EscortController.getNewEscorts(9);


           String json = new Gson().toJson(escorts);
           response.setContentType("application/json");
           response.setCharacterEncoding("UTF-8");
           response.getWriter().write(json);

       }
        if(path.equals(RECOMMENDED)) {
            ArrayList<Escort> escorts = EscortController.getRecommendedEscorts(4);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if(path.equals(ENGLAND_TOUR)) {
            ArrayList<Escort> escorts = EscortController.getEscortsFromEngland(4);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if(path.equals(OF_THE_MONTH)) {
           Escort e = EscortController.getEscortOfTheMonth(new Timestamp(new Date().getTime()).getMonth()+1);


            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if(path.equals(INFO)) {
            Escort e = EscortController.getById(Integer.parseInt(request.getParameter("escortID")));
            e.setProperties(PersonPropertyController.getPropertiesForEscort(e.getId()));

            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if(path.equals(FILTER)) {
            String filters = request.getParameter("filters");
            ArrayList<PersonProperty> props = new ArrayList<PersonProperty>();
            for (String filter : filters.split(",")) {
                PersonProperty pp = new PersonProperty();
                pp.setCode(filter);
                props.add(pp);

            }
            ArrayList<Escort> escorts = EscortController.getEscortsWithProperties(props, 9);

            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);



        }

    }
}
