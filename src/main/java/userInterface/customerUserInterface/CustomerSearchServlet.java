package userInterface.customerUserInterface;

import businessLogic.CustomerBusinessLogic;
import dataAccess.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CustomerSearchServlet", urlPatterns = {"/CustomerSearchServlet"})
public class CustomerSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String searchOption = req.getParameter("searchOption");
        String searchValue = req.getParameter("searchValue");
        ArrayList<Customer> customerList = null;
        if (searchOption.equals("firstName")) {
            customerList = CustomerBusinessLogic.searchFirstName(searchValue);
        } else if (searchOption.equals("lastName")) {
            customerList = CustomerBusinessLogic.searchLastName(searchValue);
        } else if (searchOption.equals("customerId")) {
            customerList = CustomerBusinessLogic.searchCustomerId(searchValue);
        } else if (searchOption.equals("nationalId")) {
            customerList = CustomerBusinessLogic.searchNationalId(searchValue);
        }
        System.out.println(searchOption + " " + searchValue);
        System.out.println(customerList);
        req.setAttribute("searchOption", searchOption);
        req.setAttribute("searchValue", searchValue);
        req.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("CustomerSearchResult.jsp");
        requestDispatcher.forward(req, resp);
    }
}