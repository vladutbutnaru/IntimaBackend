package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.EscortController;
import ro.enered.entities.Escort;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dioni on 12/22/2016.
 */
public class Accounts extends HttpServlet {
    private static final String EDIT = "/account/edit";
    private static final String SAVE = "/account/save";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }
    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if(path.equals(EDIT)){
            int id=Integer.parseInt(request.getParameter("id"));
            EscortController ec=new EscortController();
            Escort e=ec.getById(id);


            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if(path.equals(SAVE)){

        }
    }
}
