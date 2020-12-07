package servlets.events;

import controllers.CalendarController;
import models.Events;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/calendar")
public class CalendarServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        req.getRequestDispatcher("events/events.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getSession().getAttribute("usertype")!=null && req.getSession().getAttribute("usertype").equals("faculty"))
        {

            Events new_event = new Events(
                    req.getParameter("eventid"),
                    req.getParameter("eventdate"),
                    req.getParameter("eventname"),
                    req.getParameter("eventdesc")
            );
            System.out.println(new_event.toString());
            CalendarController controller = new CalendarController();
            if(controller.insertEvent(new_event))
            {
                req.setAttribute("message","Event added successfully");
            }
            else
            {
                req.setAttribute("message","Server error");
            }

        }
        req.getRequestDispatcher("events/events.jsp").forward(req, resp);
    }
}