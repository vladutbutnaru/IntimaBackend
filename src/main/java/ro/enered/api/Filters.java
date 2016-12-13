package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.PersonPropertyController;
import ro.enered.entities.PersonProperty;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by macbook on 04/12/2016.
 */
public class Filters extends HttpServlet {


    private static final String GENERAL = "/filters/general";
    private static final String SEXUAL = "/filters/sexual";
    private static final String PHYSICAL = "/filters/physical";
    private static final String BDSM = "/filters/bdsm";
    private static final String SOCIAL = "/filters/social";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(GENERAL)) {

        ArrayList<PersonProperty> properties;
            properties = PersonPropertyController.getByCategory((1));

            String json = new Gson().toJson(properties);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(SEXUAL)) {

            ArrayList<PersonProperty> properties;
            properties = PersonPropertyController.getByCategory((2));

            String json = new Gson().toJson(properties);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(PHYSICAL)) {

            ArrayList<PersonProperty> properties;
            properties = PersonPropertyController.getByCategory((3));

            String json = new Gson().toJson(properties);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(BDSM)) {

            ArrayList<PersonProperty> properties;
            properties = PersonPropertyController.getByCategory((4));

            String json = new Gson().toJson(properties);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(SOCIAL)) {

            ArrayList<PersonProperty> properties;
            properties = PersonPropertyController.getByCategory((5));

            String json = new Gson().toJson(properties);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }



    }

}
