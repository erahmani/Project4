package userInterface;

import businessLogic.CustomerBusinessLogic;
import dataAccess.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

@WebServlet(name = "SearchCustomerServlet", urlPatterns = {"/SearchCustomerServlet"})
public class SearchCustomerServlet extends HttpServlet {
    private static String createRealCustomerSearchHTMLResult(String searchOption, String searchValue, LinkedList<Customer> legalCustomerList) {
        String beginHtml = "<!DOCTYPE html>" +
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
                "<center>" +
                "<table>" +
                "<caption>Result for search option: " + searchOption + " search value: " + searchValue + "</caption>" +

                "<th> customerId </th> \n" +
                "<th> firstName </th> \n" +
                "<th> lastName </th> \n" +
                "<th> fatherName </th> \n" +
                "<th> birthDay </th> \n" +
                "<th> nationalId </th> \n";
        String tableRows = "";
        for (Customer customer : legalCustomerList) {
            tableRows +=
                    "<tr >" + "<form action = \" ChangeCustomerServlet \" method = \" Get \" >\n" +
                            "<td><input type = \"text\" name = \"customerId\" value = \"" + customer.getCustomerId() + "\" readonly ></td>\n" +
                            "<td><input type = \"text\" name = \"firstName\" value = \"" + customer.getFirstName() + "\" readonly ></td>\n" +
                            "<td><input type = \"text\" name = \"lastName\" value = \"" + customer.getLastName() + "\" readonly ></td>\n" +
                            "<td><input type = \"text\" name = \"fatherName\" value = \"" + customer.getFatherName() + "\" readonly ></td>\n" +
                            "<td><input type = \"text\" name = \"birthDay\" value = \"" + customer.getBirthDay() + "\" readonly ></td>\n" +
                            "<td><input type = \"text\" name = \"nationalId\" value = \"" + customer.getNationalId() + "\" readonly ></td>\n" +
                            "<input type = \"hidden\" name = \"customerType\" value = \"Customer\" required> <br>\n" +
                            "<td ><input type = \"submit\" name = \"Edit\" value = \"Edit\" ></td >" +
                            "<td ><input type = \"submit\" name = \"Delete\" value = \"Delete\" ></td >" +
                            "</tr >";
        }

        String endHtml = "</form>" +
                "</tr>" +
                "</table>" +
                "</center>" +
                "</div>" +
                "<div class=\"home-button\">" +
                "<a href=\"Main.html\">" +
                "<button>Home</button>" +
                "</a>" +
                "</div>" +
                "</body>" +
                "</html>";
        return beginHtml + tableRows + endHtml;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchOption = req.getParameter("searchOption");
        String searchValue = req.getParameter("searchValue");
        LinkedList<Customer> customerList = CustomerBusinessLogic.searchRealCustomer(searchOption, searchValue);
        String html = createRealCustomerSearchHTMLResult(searchOption, searchValue, customerList);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(html);
    }
}