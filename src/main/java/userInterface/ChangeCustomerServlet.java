package userInterface;

import businessLogic.CustomerBusinessLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "ChangeCustomerServlet", urlPatterns = {"/ChangeCustomerServlet"})
public class ChangeCustomerServlet extends HttpServlet {

    public static String createSuccessfulDeletedHTML() {
        return "<!DOCTYPE html>" +
                "<head>" +
                "<title>Title</title>" +
                "</head>" +
                "<body>" +
                "<p ><font color=\"green\"><h2 >Successful deletion </h2></font></p>" +
                "<div class=\"home-button\">" +
                "<a href=\"Main.html\">" +
                "<button>Home</button>" +
                "</a>" +
                "</div>" +
                "</body>" +
                "</html>";
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("Delete") != null) {
            String customerId = request.getParameter("customerId");
            CustomerBusinessLogic.deleteCustomer(customerId);
            String html = createSuccessfulDeletedHTML();
            PrintWriter printWriter = response.getWriter();
            printWriter.println(html);
        } else if (request.getParameter("Edit") != null) {
            String html = createRealCustomerEditHTML(request);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(html);
        }
    }

    private static String createRealCustomerEditHTML(HttpServletRequest request) {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title></title>" +
                "<style>" +
                "       html, body {" +
                "  height: 100%;" +
                "}" +
                " .dropdown-content text {" +
                "   color: black;" +
                "  padding: 12px 16px;" +
                " text-decoration: none;" +
                "   display: block;" +
                "}" +
                ".dropdown-content text:hover {" +
                "   background-color: #f1f1f1" +
                "}" +
                "div.relative {" +
                "position: relative;" +
                "top: 25%;" +
                "left: 15%;" +
                "width: 70%;" +
                "height: 50%;" +
                "border: solid lightslategrey;" +
                "   background-color: whitesmoke" +
                "}" +
                "div.home-button {" +
                "position: relative;" +
                "top: 30%;" +
                "   left: 48%;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body bgcolor=\"#20b2aa\">" +

                "<div class=\"relative\">" +
                "<center>" + "<br> <form action=\" EditCustomerServlet \" method=\"POST\">" +


                "customerId:<br>\n" +
                "<input type = \"number\" name = \"customerId\" value = \"" + request.getParameter("customerId") + "\" readonly> <br>\n" +
                "firstName:<br>\n" +
                "<input type = \"text\" name = \"firstName\" value = \"" + request.getParameter("firstName") + "\" required> <br>\n" +
                "lastName:<br>\n" +
                "<input type = \"text\" name = \"lastName\" value = \"" + request.getParameter("lastName") + "\" required> <br>\n" +
                "fatherName:<br>\n" +
                "<input type = \"text\" name = \"fatherName\" value = \"" + request.getParameter("fatherName") + "\" required> <br>\n" +
                "birthDay:<br>\n" +
                "<input type = \"date\" name = \"birthDay\" value = \"" + request.getParameter("birthDay") + "\" required> <br>\n" +
                "nationalId:<br>\n" +
                "<input type = \"number\" name = \"nationalId\" value = \"" + request.getParameter("nationalId") + "\" required> <br>\n" +


                "<input type = \"hidden\" name = \"customerType\" value = \"Customer\" required> <br>\n" +
                "<input type=\"submit\" value=\"Submit\">" +
                "<input type=\"reset\" value=\"Reset\">" +
                "</form>" +
                "</center>" +
                "</div>" +
                "<div class=\"home-button\">" +
                "<a href=\"Main.html\">" +
                "<button>Home</button>" +
                "</a>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}