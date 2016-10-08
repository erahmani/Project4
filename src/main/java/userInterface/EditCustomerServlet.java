package userInterface;

import businessLogic.CustomerBusinessLogic;
import businessLogic.exception.DuplicateUniqueCodeException;
import dataAccess.entity.Customer;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "EditCustomerServlet", urlPatterns = {"/EditCustomerServlet"})
public class EditCustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println("Economic Code: " + request.getParameter("economicCode"));
            Customer customer = Utility.initRealCustomer(request);
            CustomerBusinessLogic.editCustomer(customer);
            PrintWriter printWriter = response.getWriter();
            printWriter.println(createEditSuccessfulHTML());
        } catch (DuplicateUniqueCodeException e) {
            String html = createRealCustomerEditErrorHTML(request, e.getMessage());
            PrintWriter printWriter = response.getWriter();
            printWriter.println(html);
        }
    }

    public static String createEditSuccessfulHTML() {
        return "<!DOCTYPE html>" +
                "<head>" +
                "<title>Title</title>" +
                "</head>" +
                "<body>" +
                "<p ><font color=\"green\"><h2 >Successful Edit !!</h2></font></p>" +
                "</body>" +
                "<div class=\"home-button\">" +
                "<a href=\"Main.html\">" +
                "<button>Home</button>" +
                "</a>" +
                "</div>" +
                "</html>";
    }

    public static String createRealCustomerEditErrorHTML(HttpServletRequest request, String errorMessage) {
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
                "<p ><font color=\"red\"><h2 >" + errorMessage + "</h2></font></p>" +

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
