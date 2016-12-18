package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.*;
import ro.enered.entities.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by macbook on 06/12/2016.
 */
public class Login extends HttpServlet {

    private static final String LOGIN = "/auth/login";
    private static final String REGISTER = "/auth/register";



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)  throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(LOGIN)) {

            response.getWriter().write(AuthController.login(request.getParameter("email"),request.getParameter("password")));

        }
        if(path.equals(REGISTER)){
           String type = request.getParameter("type"); //1 member, 2 escort, 3 agency, 4 advertiser
            if(type.equals("1")) {

               String country = request.getParameter("country");
                String city = request.getParameter("city");
                String day = request.getParameter("day");
                String month = request.getParameter("month");
                String year = request.getParameter("year");
                String email = request.getParameter("email");
                String user = request.getParameter("user");
                String password=request.getParameter("password");
                Member m = new Member();
                m.setUsername(user);
                m.setPassword(password);
                m.setEmail(email);
                m.setCountry(CountryController.getById(Integer.parseInt(country)));
                m.setCity(CityController.getById(Integer.parseInt(city)));
                Date d = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                Timestamp ts = new Timestamp(d.getTime());
                m.setBirthDate(ts);
                MemberController.registerMember(m);

            }

            if(type.equals("2")) {

                String city = request.getParameter("city");
                String day = request.getParameter("day");
                String month = request.getParameter("month");
                String year = request.getParameter("year");
                String email = request.getParameter("email");
                String user = request.getParameter("user");
                String category = request.getParameter("category");
                String password=request.getParameter("password");
                Escort m = new Escort();
                m.setStageName(user);
                m.setPassword(password);
                m.setEmail(email);
                m.setCategory(CategoryController.getById(Integer.parseInt(category)));
                m.setCity(CityController.getById(Integer.parseInt(city)));
                Date d = new Date(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
                Timestamp ts = new Timestamp(d.getTime());
                m.setBirthDate(ts);
                EscortController.registerEscort(m);

            }
            if(type.equals("3")) {

                String city = request.getParameter("city");

                String email = request.getParameter("email");
                String user = request.getParameter("user");

                String password=request.getParameter("password");
                MassageAgency m = new MassageAgency();
                m.setUser(user);
                m.setPassword(password);
                m.setEmail(email);

                m.setCity(CityController.getById(Integer.parseInt(city)));

                MassageAgencyController.registerAgency(m);

            }
            if(type.equals("4")) {


                String email = request.getParameter("email");


                String password=request.getParameter("password");
                Advertiser m = new Advertiser();

                m.setPassword(password);
                m.setEmail(email);



                AdvertiserController.registerAdvertiser(m);

            }
        }
    }




}
