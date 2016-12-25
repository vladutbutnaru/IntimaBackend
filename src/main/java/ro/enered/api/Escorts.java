package ro.enered.api;

import com.google.gson.Gson;
import ro.enered.controllers.CityController;
import ro.enered.controllers.EscortController;
import ro.enered.controllers.PersonPropertyController;
import ro.enered.entities.Category;
import ro.enered.entities.Escort;
import ro.enered.entities.PersonProperty;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by macbook on 29/11/2016.
 */
public class Escorts extends javax.servlet.http.HttpServlet {
    private static final String NEW = "/escorts/new";
    private static final String ALL = "/escorts/all";
    private static final String FEMALE = "/escorts/female";
    private static final String FEMALEWITHFILTERS = "/escorts/female/withfilters";
    private static final String LESBIAN = "/escorts/lesbian";
    private static final String MEN = "/escorts/men";
    private static final String GAYS = "/escorts/gays";
    private static final String TS = "/escorts/ts";
    private static final String TV = "/escorts/tv";
    private static final String COUPLES = "/escorts/couples";
    private static final String RECOMMENDED = "/escorts/recommended";
    private static final String ENGLAND_TOUR = "/escorts/england";
    private static final String OTHER_COUNTRIES = "/escorts/other";
    private static final String OF_THE_MONTH = "/escorts/ofthemonth";
    private static final String INFO = "/escorts/info";
    private static final String FILTER = "/escorts/filter";
    private static final String REGISTER = "/escorts/register";
    private static final String ACCOUNT = "/escorts/account";

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        processRequest(request, response);
        System.out.println(request.getServletPath());

    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        if (path.equals(ACCOUNT)) {

            EscortController ec = new EscortController();
            int id_escorta = Integer.parseInt(request.getParameter("id"));
            Escort e = ec.getById(id_escorta);

            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(NEW)) {
            ArrayList<Escort> escorts = EscortController.getNewEscorts(4);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(ALL)) {
            ArrayList<Escort> escorts = EscortController.getNewEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(FEMALE)) {

            ArrayList<Escort> escorts = EscortController.getFemaleEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

        if (path.equals(FEMALEWITHFILTERS)) {
            String filters = request.getParameter("filters");
            System.out.println(filters);
            if (filters != "" && filters != null && filters != ",") {
                System.out.println(filters);
                ArrayList<PersonProperty> properties = new ArrayList<PersonProperty>();
                for (int i = 0; i < filters.split(",").length; i++) {
                    PersonProperty pp = PersonPropertyController.getByCode(filters.split(",")[i]);
                    properties.add(pp);
                    System.out.println(pp.getCode());
                }

                ArrayList<Escort> escorts = EscortController.getEscortsWithProperties(properties, 9);
                String json = new Gson().toJson(escorts);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            } else {
                ArrayList<Escort> escorts = EscortController.getFemaleEscorts(9);


                String json = new Gson().toJson(escorts);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);

            }

        }

        if (path.equals(GAYS)) {

            ArrayList<Escort> escorts = EscortController.getGayEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

        if (path.equals(LESBIAN)) {

            ArrayList<Escort> escorts = EscortController.getLesbianEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(MEN)) {

            ArrayList<Escort> escorts = EscortController.getMenEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }


        if (path.equals(TS)) {

            ArrayList<Escort> escorts = EscortController.getTSEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        if (path.equals(TV)) {

            ArrayList<Escort> escorts = EscortController.getTVEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }

        if (path.equals(COUPLES)) {

            ArrayList<Escort> escorts = EscortController.getCoupleEscorts(9);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }


        if (path.equals(RECOMMENDED)) {
            ArrayList<Escort> escorts = EscortController.getRecommendedEscorts(4);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }
        if (path.equals(ENGLAND_TOUR)) {
            ArrayList<Escort> escorts = EscortController.getEscortsFromEngland(4);


            String json = new Gson().toJson(escorts);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if (path.equals(OF_THE_MONTH)) {
            Escort e = EscortController.getEscortOfTheMonth(new Timestamp(new Date().getTime()).getMonth() + 1);


            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if (path.equals(INFO)) {
            Escort e = EscortController.getById(Integer.parseInt(request.getParameter("escortID")));
            e.setProperties(PersonPropertyController.getPropertiesForEscort(e.getId()));
            e.setDefault_properties(PersonPropertyController.getDefaultValues());


            String json = new Gson().toJson(e);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);

        }

        if (path.equals(FILTER)) {
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
        if (path.equals(REGISTER)) {
            Escort e = new Escort();
            e.setEmail(request.getParameter("email"));
            e.setStageName(request.getParameter("user"));
            e.setPassword(request.getParameter("password"));
            int day = Integer.parseInt(request.getParameter("birthDay"));
            int month = Integer.parseInt(request.getParameter("birthMonth"));
            int year = Integer.parseInt(request.getParameter("birthYear"));
            Calendar c = Calendar.getInstance();
            c.set(year, month - 1, day, 0, 0);
            Date date = c.getTime();
            Timestamp birthDay = new Timestamp(date.getTime());
            e.setBirthDate(birthDay);
            e.setCity(CityController.getByName(request.getParameter("city")));

            Category category = new Category();
            category.setId(Integer.parseInt(request.getParameter("type")));
            e.setCategory(category);
            int escortId = EscortController.registerEscort(e);
            response.getWriter().write("1," + escortId);
            System.out.println(escortId);


        }

    }
}
