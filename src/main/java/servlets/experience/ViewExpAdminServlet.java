package servlets.experience;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = "/view-exps")

public class ViewExpAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String role = (String)req.getSession().getAttribute("usertype");
        System.out.println(role);

        if(!role.equals("faculty")){
            resp.sendRedirect(req.getContextPath() + "/index.jsp?message="+ URLEncoder.encode("You are not a faculty!", "UTF-8"));
        }else{
            req.getRequestDispatcher("placementexp/admin/viewExp.jsp").forward(req, resp);
            String action = req.getServletPath();
            System.out.println(action);
        }
    }

}